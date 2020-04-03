package com.yanggy.kotlin.config.security

import com.yanggy.kotlin.config.jwt.JwtUser
import io.jsonwebtoken.Jwt
import org.springframework.security.core.context.SecurityContextHolder

/**
 * @ClassName SecurityUtils
 * @Author yanggy
 * @Time 2020/4/1-18:08
 * @Description
 */
class SecurityUtils {
    companion object {
        fun getSecurityUser(): JwtUser? {
            val user = SecurityContextHolder.getContext().authentication.principal ?: return null

            return user as JwtUser
        }
    }
}