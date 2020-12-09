package com.boot.security.server.config;

import java.io.IOException;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 配置自动启动浏览器
 */
@Component
public class AutoRun implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
	private int port;

	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		this.port = event.getEmbeddedServletContainer().getPort();
		try {
			Runtime.getRuntime().exec("cmd   /c   start   http://127.0.0.1:" + port + "/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
