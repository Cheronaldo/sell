package com.cherry.service.impl;

import com.cherry.dataobject.SellerInfo;
import com.cherry.repository.SellerInfoRepository;
import com.cherry.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/14.
 */
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findSellerInfoByOpenid(openid);
    }
}
