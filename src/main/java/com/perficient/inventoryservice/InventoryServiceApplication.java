package com.perficient.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class InventoryServiceApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }


//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                String urls = env.getProperty("cors.urls");
//                CorsRegistration reg = registry.addMapping("/api/**");
//                for(String url: urls.split(",")) {
//                    reg.allowedOrigins(url);
//                }
//            }
//        };

//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                String urls = env.getProperty("cors.urls");
//                CorsRegistration reg = registry.addMapping("/api/**");
//                for(String url: urls.split(",")) {
//                    reg.allowedOrigins("url");
//                }
//            }
//        };
//    }
}
