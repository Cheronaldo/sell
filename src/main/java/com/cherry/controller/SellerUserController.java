package com.cherry.controller;

import com.cherry.config.ProjectUrlConfig;
import com.cherry.constant.CookieConstant;
import com.cherry.constant.RedisConstant;
import com.cherry.dataobject.SellerInfo;
import com.cherry.enums.ResultEnum;
import com.cherry.service.SellerService;
import com.cherry.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/14.
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object> map){

        //1. openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");//可以直接写一个登录界面，登录设备就跳转到登录界面
            return new ModelAndView("common/error");
        }
        //2. 设置token至redis
        String token= UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        //将redis的key:token格式化 以 RedisConstant.TOKEN_PREFIX 为头  token 为值 ，openid是需要设置的用户信息值，expire为过期时间 单位是 s
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);

        //3. 设置token至cookie  通过 HttpServletResponse 对象写入 response中
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        //这里只需要跳转(跳转最好用绝对路径进行跳转)，不需要传入参数进行页面的渲染
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
        //return new ModelAndView("redirect:/seller/order/list");

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object> map){

        //1.从cookie中查询 要获取request中 token头为CookieConstant.TOKEN 的token值
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie  在response中清除  将值设为 null 过期时间设为 0 即可
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }

        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");

        return new ModelAndView("common/success",map);


    }


}
