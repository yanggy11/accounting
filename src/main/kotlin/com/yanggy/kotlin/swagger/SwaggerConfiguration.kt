package com.yanggy.kotlin.swagger

import io.swagger.annotations.SwaggerDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @ClassName SwaggerConfiguration
 * @Author yanggy
 * @Time 2020/3/28-11:40
 * @Description
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun createRestApi() : Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(""))
                .paths(PathSelectors.any())
                .build();
    }

    private fun apiInfo() :ApiInfo {
        return ApiInfoBuilder()
                .title("记账系统")
                .description("powered by derrick yang")
                .termsOfServiceUrl("http://www.by-health.com/")
                //.contact(contact)
                .version("1.0")
                .build();
    }
}