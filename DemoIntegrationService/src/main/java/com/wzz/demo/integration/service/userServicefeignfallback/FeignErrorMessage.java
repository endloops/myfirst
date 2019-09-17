package com.wzz.demo.integration.service.userServicefeignfallback;

import java.io.IOException;

import org.springframework.context.annotation.Bean;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

public class FeignErrorMessage {
	@Bean
	public ErrorDecoder errorDecoder() {
		return new UserErrorDecoder();
	}

	/**
	 * 自定义错误
	 */
	public class UserErrorDecoder implements ErrorDecoder {
		@Override
		public Exception decode(String methodKey, Response response) {
			Exception exception = null;

			// 获取原始的返回内容
			String json = null;
			try {
				json = Util.toString(response.body().asReader());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 将返回内容反序列化为Result，这里应根据自身项目作修改
			// 业务异常抛出简单的 RuntimeException，保留原来错误信息
			exception = new RuntimeException(json);

			return exception;
		}
	}
}
