package com.yanggy.kotlin.cors

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

/**
 * @ClassName CorsConfiguration
 * @Author yanggy
 * @Time 2020/4/3-18:17
 * @Description
 */

@Configuration
class Configuration {
    @Bean
    fun corsFilter(): CorsFilter? { //1.添加CORS配置信息
        val config = CorsConfiguration()
        //放行哪些原始域
        config.addAllowedOrigin("*")
        //是否发送Cookie信息
        config.setAllowCredentials(true)
        //放行哪些原始域(请求方式)
        config.addAllowedMethod("*")
        //放行哪些原始域(头部信息)
        config.addAllowedHeader("*")
        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        config.addExposedHeader("Header1")
        //2.添加映射路径
        val configSource = UrlBasedCorsConfigurationSource()
        configSource.registerCorsConfiguration("/**", config)
        //3.返回新的CorsFilter.
        return CorsFilter(configSource)
    }
}