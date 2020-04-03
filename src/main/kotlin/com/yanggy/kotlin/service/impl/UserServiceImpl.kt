package com.yanggy.kotlin.service.impl

import com.yanggy.kotlin.common.ErrorCode
import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.common.ResponseEntityBuilder
import com.yanggy.kotlin.config.jwt.JwtTokenUtil
import com.yanggy.kotlin.config.jwt.JwtUser
import com.yanggy.kotlin.dao.UserMapper
import com.yanggy.kotlin.dto.UserDto
import com.yanggy.kotlin.service.IUserService
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource


@Service("userService")
class UserServiceImpl : IUserService {

    @Resource
    private lateinit var jwtTokenUtil: JwtTokenUtil;

    @Resource
    private lateinit var authenticationManager:AuthenticationManager;

    @Resource
    private lateinit var userMapper: UserMapper;
    @Value("\${jwt.tokenHead}")
    private lateinit var tokenHead: String;

    override fun login(user: com.yanggy.kotlin.entity.User): ResponseEntity<Any?>? {
        var res:ResponseEntity<Any?>? = null
        var authentication:Authentication? = null
        return try {
            //验证密码
            val userNamePasswordAuthentication: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(user.userName, user.password)
            authentication = authenticationManager.authenticate(userNamePasswordAuthentication)

            //生成token
            if(null != authentication) {
                val jwtUser:JwtUser = authentication.principal as JwtUser
                val token:String = StringBuilder().append(tokenHead).append(" ").append(jwtTokenUtil.generateToken(jwtUser)).toString()
                ResponseEntityBuilder.buildNormalResponse(mapOf<String, Any>("token" to token, "user" to UserDto.buildUserDto(jwtUser)))
            }else {
                ResponseEntityBuilder.buildErrorResponse(ErrorCode.USER_PASSWORD_ERROR)
            }

        }catch (exception:Exception) {
            ResponseEntityBuilder.buildErrorResponse(ErrorCode.ERROR)
        }
    }

}