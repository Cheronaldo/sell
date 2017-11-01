package com.cherry.exception;

import com.cherry.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by Administrator on 2017/09/28.
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

       super(resultEnum.getMessage());

       this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
