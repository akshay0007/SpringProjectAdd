//package com.myproject.example.configure;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.myproject.example")
//public class WebAppConfig {
//
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
////		resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//}