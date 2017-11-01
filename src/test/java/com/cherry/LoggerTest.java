package com.cherry;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/09/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
//        logger.debug("debug....");
//        logger.info("info...");//ctrl+N 查找类名 level-> slf4j  数字越大 优先级越高
//        //系统默认级别为 info 低于 info级别的日志不打印
//        logger.error("error...");

        String name = "cherry";
        String password = "123";

        log.info("name:"+name + "password:" + password);

        log.info("name:{},password: {}",name,password);//变量拼接输出


       log.debug("debug....");
       log.info("info...");
       log.error("error...");


    }


}
