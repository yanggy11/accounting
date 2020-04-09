package com.yanggy.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

/**
 * @ClassName TodoItemsServiceImpl
 * @Author yanggy
 * @Time 2020/3/26-17:40
 * @Description the main method of accounting system
 */
@SpringBootApplication
class AccountingApplication

fun main(args: Array<String>) {
    runApplication<AccountingApplication>(*args)
}

@Bean
fun corsFilter(): CorsFilter? { //1.添加CORS配置信息
    val config = CorsConfiguration()
    //放行哪些原始域
    config.addAllowedOrigin("*")
    //是否发送Cookie信息
    config.allowCredentials = true
    //放行哪些原始域(请求方式)
    config.addAllowedMethod("*")
    //放行哪些原始域(头部信息)
    config.addAllowedHeader("*")
    //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
    config.addExposedHeader("*")
    //2.添加映射路径
    val configSource = UrlBasedCorsConfigurationSource()
    configSource.registerCorsConfiguration("/**", config)
    //3.返回新的CorsFilter.
    return CorsFilter(configSource)
}
