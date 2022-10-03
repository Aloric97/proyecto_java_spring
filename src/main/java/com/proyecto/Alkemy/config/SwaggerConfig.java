package com.proyecto.Alkemy.config;


import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

    @Bean
    public Docket api() {

        //return a prepared Docket instance
        //https://127.0.0.1:3000/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.proyecto.Alkemy.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}
