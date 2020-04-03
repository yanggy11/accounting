package com.yanggy.kotlin.dto

import com.yanggy.kotlin.config.jwt.JwtUser
import org.springframework.security.core.GrantedAuthority
import java.util.*

/**
 * @ClassName UserDto
 * @Author yanggy
 * @Time 2020/4/3-11:13
 * @Description
 */
data class UserDto(
    var userId: Long? = null,
    var username: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var avater: String? = null,
    var authorities: Collection<GrantedAuthority?>? = null
){

    val serialVersionUID = -8265778093676125189L

    companion object {
        fun buildUserDto(jwtUser: JwtUser): UserDto = UserDto(jwtUser.getUserId(),
                jwtUser.username, jwtUser.getEmail(),
                jwtUser.getPhone(), jwtUser.getAvater(), jwtUser.authorities)
    }

}