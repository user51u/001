package com.boots.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/news").setViewName("news");
        registry.addViewController("/indexadmin").setViewName("indexadmin");
        registry.addViewController("/regwor").setViewName("regwor");
        registry.addViewController("/workplace").setViewName("workplace");
        registry.addViewController("/bron").setViewName("bron");
    }
}
