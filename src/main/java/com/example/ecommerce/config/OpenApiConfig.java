package com.example.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${spring.application.name}")String name,
                           @Value("${spring.application.author}")String author,
                           @Value("${spring.application.version}")String version
    ){
        return new OpenAPI().info(new Info()
                .title(name)
                .version(version)
                .license(new License().name(author)));
    }
}
