package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.app.*")
public class Config extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver view() {
		InternalResourceViewResolver view  = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/");
		view.setSuffix(".jsp");
		view.setViewClass(JstlView.class);
		return view;
	}
}
