package com.cherry.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象  （即返回给前端的内容）
 * Created by Administrator on 2017/09/25.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable{

    //快捷键：ctr+shift+Q自动生成ID
    //VO 面对前端 经常需要序列化


    private static final long serialVersionUID = -759324683836013925L;

    //自定义返回数据的格式

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;

    public ResultVO() {}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
