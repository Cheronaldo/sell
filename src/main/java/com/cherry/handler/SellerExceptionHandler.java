package com.cherry.handler;

import com.cherry.VO.ResultVO;
import com.cherry.config.ProjectUrlConfig;
import com.cherry.exception.ResponseBankException;
import com.cherry.exception.SellAuthorizeException;
import com.cherry.exception.SellException;
import com.cherry.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/15.
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常  value值是要处理的异常类的类名
    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
//        return new ModelAndView("redirect:"
//                .concat(projectUrlConfig.getSell())
//                .concat("/sell/seller/order/list"));//目前跳转的还是列表界面
//        //后期可以做成课程中的扫码页面 或者自己写一个 包含 用户名 密码 openid的 登录界面

        return new ModelAndView("redirect:"
                .concat("https://www.baidu.com/index.php?tn=monline_3_dg"));//用跳转至百度做测试



    }

    /**
     * 捕获商品不存在异常  @ResponseBody 是的返回格式是 json；
     * 但是在买家订单controller中已经有@RestController ，这里是否有必要 再加@ResponseBody  注解 可以测试
     * @param e
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());

    }

    /**
     * 以银行类异常为例 自定义返回给前端的 code类型值 通过@ResponseStatus注解实现修改
     */
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){

    }


}
