package com.ddz.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                该包路径下的Controller类才会自动生成Swagger API文档
                .apis(RequestHandlerSelectors.basePackage("com.ddz.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("学习测试")
                .description("学习中心API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://www.baidu.com/")
                .version("1.0")
                .contact(new Contact("ddz","http://www.baidu.com/","ddz@huitone.com"))
                .build();
    }
}
