package com.cherry.service;

import com.cherry.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by Administrator on 2017/10/14.
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
