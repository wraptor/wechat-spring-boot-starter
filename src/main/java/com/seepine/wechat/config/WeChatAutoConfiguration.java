package com.seepine.wechat.config;

import com.seepine.wechat.WeChatProperties;
import com.seepine.wechat.service.WeChatTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Seepine
 */
@AllArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({WeChatProperties.class})
public class WeChatAutoConfiguration {
	private final WeChatProperties weChatProperties;

	@Bean
	@ConditionalOnMissingBean(WeChatTemplate.class)
	public WeChatTemplate weChatTemplate() {
		return new WeChatTemplate(weChatProperties);
	}
}
