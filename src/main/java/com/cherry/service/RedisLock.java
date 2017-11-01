package com.cherry.service;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/10/16.
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if(redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        //防止死锁
        //假设上一个锁的value是A 则执行这一句后currentValue=A
        // 再假设有2个线程1 2的value都是B
        //假设这两个线程 同时执行到这个地方 同时获取到currentValue=A
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间  获取oldValue这句代码只能被一个线程执行
            /**
             * 假设线程1 先进来执行
             * 则线程1拿到的 oldValue = A，并且将redis缓存里的 value值 设置为了 B
             * 此时oldValue.equals(currentValue) 成立，则线程1拿到了锁
             * 线程1执行完后，线程2进来，此时currentValue还停留在是一个锁设置的value值中，即仍然是A
             * 线程2再获取oldValue，由于线程1已经将redis缓存里的 value值 设置为了 B，所以线程2获取的oldValue值就是B
             * 此时oldValue.equals(currentValue) 不成立，线程2拿不到锁，从而保证在多线程时只有一个线程能拿到锁。
             */
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }



        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }

}
