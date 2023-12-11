package com.c1538njavareact.serviLink.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servilink API")
                        .version("v0.01")
                        .description("Documentation Servilink API v0.01")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/"))
                        .contact(new Contact()
                                .name("DEMO")
                                .url("https://demo.vercel.app/"))
                );
    }

}
