package com.seepine.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seepine.http.entity.Request;
import com.seepine.http.entity.Response;
import com.seepine.http.lang.Assert;
import com.seepine.http.util.HttpUtil;
import com.seepine.wechat.constant.ApiConstant;
import com.seepine.wechat.WeChatProperties;
import com.seepine.wechat.constant.ErrorConstant;
import com.seepine.wechat.constant.KeyConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;


/**
 * @author Seepine
 */
@Slf4j
@RequiredArgsConstructor
public class WeChatTemplate implements InitializingBean {

	private final WeChatProperties weChatProperties;

	@Override
	public void afterPropertiesSet() {
		log.debug("afterPropertiesSet WeChatTemplate");
	}

	/**
	 * jsCode转openId
	 *
	 * @param jsCode 小程序wx.login获得的jsCode
	 * @return openId
	 * @throws Exception Exception
	 */
	public String getOpenId(String jsCode) throws Exception {
		Response resBody = HttpUtil.execute(Request.build(String.format(ApiConstant.MINI_APP_AUTHORIZATION_CODE_URL
			, weChatProperties.getAppId(), weChatProperties.getAppSecret(), jsCode)));
		if (resBody.getStatus() == HttpStatus.OK.value()) {
			JSONObject res = JSON.parseObject(resBody.getBody());
			String openId = res.getString(KeyConstant.OPENID_KEY);
			Assert.isNotBlank(openId, ErrorConstant.OPEN_ID_ERROR_MESSAGE);
			return openId;
		} else {
			throw new IllegalArgumentException(resBody.getBody());
		}
	}

	/**
	 * 获取accessToken
	 *
	 * @return accessToken
	 * @throws Exception Exception
	 */
	public String getAccess() throws Exception {
		Response resBody = HttpUtil.execute(Request.build(String.format(ApiConstant.ACCESS_URL
			, weChatProperties.getAppId(), weChatProperties.getAppSecret())));
		if (resBody.getStatus() == HttpStatus.OK.value()) {
			JSONObject res = JSON.parseObject(resBody.getBody());
			String access = res.getString(KeyConstant.ACCESS_TOKEN_KEY);
			Assert.isNotBlank(access, ErrorConstant.ACCESS_TOKEN_ERROR_MESSAGE);
			return access;
		} else {
			throw new IllegalArgumentException(resBody.getBody());
		}
	}
}
