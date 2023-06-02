package com.gdu.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gdu.home.intercept.LoginCheckInterceptor;
import com.gdu.home.util.MyFileUtil;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
	
	// field
	private final LoginCheckInterceptor loginCheckInterceptor;
	private final MyFileUtil myFileUtil;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loginCheckInterceptor)
			.addPathPatterns("/bbs/write.html", "/upload/write.html");
		
//		registry.addInterceptor(loginCheckInterceptor)
//			.addPathPatterns("/**") // 모든 요청에 실행
//			.excludePathPatterns("/user/leave.do"); // 제외할 요청
	
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/imageLoad/**")
			.addResourceLocations("file:" + myFileUtil.getSummernoteImagePath() + "/");
	
	}
	

}
