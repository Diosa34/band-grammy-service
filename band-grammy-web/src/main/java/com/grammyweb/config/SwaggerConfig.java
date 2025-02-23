package com.grammyweb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Info info = new Info()
                // todo: исправить
                .title("Сервис музыкальных групп")
                .version("1.1.0")
                .description("Документация API для лабораторной работы по Сервис-ориентированной архитектуре.");
        return new OpenAPI()
                .info(info);
    }
}
