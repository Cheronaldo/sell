package com.cherry.utils;

import com.cherry.VO.ResultVO;

/**
 * Created by Administrator on 2017/09/25.
 */
public class ResultVOUtil {

    /**
     * 成功 且有数据对象
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * 成功 但没有数据对象
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 返回失败的结果
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }


}
