package com.seepine.wechat.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.seepine.wechat.constant.CommonConstant;
import com.seepine.wechat.WeChatProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;


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

	@SneakyThrows
	public String getOpenId(String jsCode) {
		String result = HttpUtil.get(String.format(CommonConstant.MINI_APP_AUTHORIZATION_CODE_URL
			, weChatProperties.getAppId(), weChatProperties.getAppSecret(), jsCode));
		JSONObject res = JSONUtil.parseObj(result);
		String openId = res.getStr(CommonConstant.OPENID_KEY);
		if (StrUtil.isNotBlank(openId)) {
			return openId;
		}
		throw new Exception();
	}

	@SneakyThrows
	public String getAccess() {
		String result = HttpUtil.get(String.format(CommonConstant.ACCESS_URL, weChatProperties.getAppId(), weChatProperties.getAppSecret()));
		String access = JSONUtil.parseObj(result).getStr(CommonConstant.ACCESS_TOKEN_KEY);
		if (StrUtil.isNotBlank(access)) {
			return access;
		}
		throw new Exception();
	}
}
