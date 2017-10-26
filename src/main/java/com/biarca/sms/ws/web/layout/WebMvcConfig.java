package com.biarca.sms.ws.web.layout;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ThymeleafLayoutInterceptor());
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/sms/login").setViewName("signin/login");
    registry.addViewController("/sms/dashboard").setViewName("user/dashboard");
    registry.addViewController("/sms/services").setViewName("user/services");
    registry.addViewController("/sms/about").setViewName("user/about");
    registry.addViewController("/sms/contact").setViewName("user/contact");
  }
}
