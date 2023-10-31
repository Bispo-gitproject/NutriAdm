package com.nutriadm.Nutriadm.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nutriadm.Nutriadm.Controller"))
                .paths(PathSelectors.any())
                .build()
                .pathProvider(new RelativePathProvider(null) {
                    @Override
                    public String getApplicationBasePath() { return "/";}
                });
    }
}
