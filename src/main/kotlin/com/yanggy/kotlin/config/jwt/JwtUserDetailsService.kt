package com.yanggy.kotlin.config.jwt

import com.yanggy.kotlin.dao.UserMapper
import com.yanggy.kotlin.entity.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @ClassName JwtUserDetailsService
 * @Author yanggy
 * @Time 2020/4/1-16:56
 * @Description
 */

@Service("userDetailService")
class JwtUserDetailsService : UserDetailsService {
    @Resource
    private lateinit var userMapper: UserMapper

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(name: String?): UserDetails? {
        var user = User()
        try {
            user = userMapper.findByName(name)
            user.authorities =(userMapper.getUserRoles(user.id))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (null == user.id) {
            throw UsernameNotFoundException(String.format("No user found with username '%s'.", name))
        }
        return JwtUser(user);
    }
}