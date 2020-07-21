package com.seepine.wechat.constant;

/**
 * @author Seepine
 */
public interface CommonConstant {
    /**
     * 微信小程序OPENID
     */
    String MINI_APP_AUTHORIZATION_CODE_URL = "https://api.weixin.qq.com/sns/jscode2session" +
            "?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    String OPENID_KEY = "openid";
    String ACCESS_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    String ACCESS_TOKEN_KEY = "access_token";

}
