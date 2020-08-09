package com.seepine.wechat.constant;

/**
 * @author Seepine
 */
public interface ApiConstant {
	/**
	 * 微信小程序jsCode转openId的url
	 */
	String MINI_APP_AUTHORIZATION_CODE_URL = "https://api.weixin.qq.com/sns/jscode2session" +
		"?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
	/**
	 * 微信小程序获取access的url
	 */
	String ACCESS_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

}
