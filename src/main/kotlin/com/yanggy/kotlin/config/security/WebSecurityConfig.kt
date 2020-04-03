package com.yanggy.kotlin.config.security

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm
import com.yanggy.kotlin.config.jwt.JwtAuthenticationTokenFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.annotation.Resource

/**
 * @ClassName WebSecurityConfig
 * @Author yanggy
 * @Time 2020/4/1-18:12
 * @Description spring security配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Resource
    private lateinit var userDetailsService: UserDetailsService

    /**
     * 设置认证方式以及密码加密算法
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    @Throws(Exception::class)
    fun configureAuthentication(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder // 设置UserDetailsService
                .userDetailsService(userDetailsService) // 使用MD5进行密码
                .passwordEncoder(passwordEncoder())
    }

    // 装载md5密码编码器
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return MessageDigestPasswordEncoder("MD5")
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Autowired
    private  lateinit var jwtAuthenticationTokenFilter: JwtAuthenticationTokenFilter

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable() //设置jwt过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter::class.java) // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers( //设置不走拦截的URL
                        "/actuator/**",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.ttf",
                        "/**/*.woff2",
                        "/**/*.css",
                        "/**/*.js",
                        "/api/notifications/**",
                        "/**/*.png",
                        "/api/journal/**",
                        "/info",
                        "/trace",
                        "/health",
                        "/beans",
                        "/env",
                        "/metrics",
                        "/refresh",
                        "/auditevents",
                        "/jolokia/**",
                        "/heapdump",
                        "/threads",
                        "/api/applications/**",
                        "/features ",
                        "/archaius",
                        "/auditevents",
                        "/mappings",
                        "/resume",
                        "/configprops",
                        "/restart",
                        "/routes",
                        "/**/auth/**",
                        "/loggers",
                        "/api/notifications/**",
                        "/insertData",
                        "/solr/**")
                .permitAll()
                .antMatchers("/auth/**").permitAll().
                        antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()

        // 禁用缓存
        httpSecurity.headers().cacheControl()
    }
}