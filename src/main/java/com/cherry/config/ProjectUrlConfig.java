package com.cherry.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/15.
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统url
     */
    public String sell;

    public String getWechatMpAuthorize() {
        return wechatMpAuthorize;
    }

    public void setWechatMpAuthorize(String wechatMpAuthorize) {
        this.wechatMpAuthorize = wechatMpAuthorize;
    }

    public String getWechatOpenAuthorize() {
        return wechatOpenAuthorize;
    }

    public void setWechatOpenAuthorize(String wechatOpenAuthorize) {
        this.wechatOpenAuthorize = wechatOpenAuthorize;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
}
