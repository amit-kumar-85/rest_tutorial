package com.dummy.potter.rest_tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dummy.potter"))
                .paths(PathSelectors.ant("/pet/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Pets API",
                "Sample API for pets",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Potter", "https://dummy.com", "gmail@dummy.com"),
                "API License",
                "https://dummy.com",
                Collections.emptyList());
    }
}
