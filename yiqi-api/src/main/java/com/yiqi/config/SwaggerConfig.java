package com.yiqi.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class SwaggerConfig {

    //自定义异常信息
    ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {{
        add(new ResponseMessageBuilder().code(500).message("未知异常，请联系管理员").build());
        add(new ResponseMessageBuilder().code(501).message("参数为空").build());
        add(new ResponseMessageBuilder().code(300).message("查找不到对应数据").build());
        add(new ResponseMessageBuilder().code(1).message("失败").build());
        add(new ResponseMessageBuilder().code(0).message("成功").build());
    }};

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //加了ApiOperation注解的类，才生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("io.yiqi.controller"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(security())
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.POST, responseMessages)
            .globalResponseMessage(RequestMethod.GET, responseMessages);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("一七科技有限公司")
            .description("yiqi-api文档")
            .termsOfServiceUrl("http://www.yiqi.io")
            .version("3.2.0")
            .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
            new ApiKey("token", "token", "header")
        );
    }

}