package com.seepine.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author Seepine
 */
@Data
@ConfigurationProperties(prefix = "we-chat")
public class WeChatProperties {
	private String appId;
	private String appSecret;
}
