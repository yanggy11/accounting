package com.yanggy.kotlin.config.jwt

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.annotation.Resource
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @ClassName JwtAuthenticationTokenFilter
 * @Author yanggy
 * @Time 2020/4/1-17:59
 * @Description JWT token 验证拦截器
 */

@Component
class JwtAuthenticationTokenFilter : OncePerRequestFilter() {

    @Resource
    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    private lateinit var jwtTokenUtil: JwtTokenUtil

    @Value("\${jwt.header}")
    private lateinit var tokenHeader: String;

    @Value("\${jwt.tokenHead}")
    private lateinit var tokenHead: String

    override fun doFilterInternal(request:HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authHeader = request.getHeader(this.tokenHeader)

        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // The part after "Bearer "
            val authToken: String = authHeader.substring(this.tokenHead.length)
            val username: String? = jwtTokenUtil.getUsernameFromToken(authToken)
            logger.info("checking authentication $username")
            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                val userDetails: UserDetails? = this.userDetailsService.loadUserByUsername(username)
                if (null != userDetails && jwtTokenUtil.validateToken(authToken, userDetails)) {
                    val authentication = UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.authorities)
                    authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                    logger.info("authenticated user $username, setting security context")
                    SecurityContextHolder.getContext().authentication = authentication
                }
            }
        }

        chain.doFilter(request, response)
    }
}