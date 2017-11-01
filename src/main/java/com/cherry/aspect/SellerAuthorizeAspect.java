package com.cherry.aspect;

import com.cherry.constant.CookieConstant;
import com.cherry.constant.RedisConstant;
import com.cherry.exception.SellAuthorizeException;
import com.cherry.exception.SellException;
import com.cherry.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/15.
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //设置身份验证切入点  对以Seller开头的操作中除去登录 登出 外的其他操作进行身份验证
    @Pointcut("execution(public * com.cherry.controller.Seller*.*(..))" +
    "&& !execution(public * com.cherry.controller.SellerUserController.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        验证流程 ： 先去cookie中拿到token值，再将token值送到redis中验证openid

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie == null){
            log.warn("【登录校验】 Cookie中查不到token");
            throw new SellAuthorizeException();
            //直接抛异常 然后通过异常捕获去处理并跳转至相关的页面
        }

        //去redis里查询 注意格式化
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】 Redis中查不到token");
            throw new SellAuthorizeException();
        }


    }

}
