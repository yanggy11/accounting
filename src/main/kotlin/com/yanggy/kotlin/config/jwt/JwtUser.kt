package com.yanggy.kotlin.config.jwt

import com.yanggy.kotlin.entity.User
import org.apache.commons.lang3.StringUtils
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.*
import java.util.stream.Collectors

/**
 * @ClassName JwtUser
 * @Author yanggy
 * @Time 2020/4/1-16:40
 * @Description
 */
class JwtUser() : UserDetails, Serializable {
    private val serialVersionUID = -8265778093676125189L
    private var userId: Long? = null
    private var username: String? = null
    private var password: String? = null
    private var email: String? = null
    private var phone: String? = null
    private var avater: String? = null
    private var authorities: Collection<GrantedAuthority?>? = null
    private var lastPasswordResetDate: Date? = null

    constructor(user:User):this() {
        this.userId = user.id
        this.username = user.userName
        this.password = user.password
        this.email = user.email
        this.phone = user.phone
        this.avater = user.avatar
        this.authorities = mapToGrantedAuthorities(user.authorities)
        this.lastPasswordResetDate = user.lastPasswordResetDate
    }

    override fun getUsername(): String? {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return authorities
    }

    fun getLastPasswordResetDate(): Date? {
        return lastPasswordResetDate
    }

    fun getUserId(): Long? {
        return userId
    }

    fun setAvater(avater: String?) {
        this.avater = avater
    }

    fun getAvater(): String? {
        return avater
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone
    }

    fun mapToGrantedAuthorities(authorities: List<String>): List<GrantedAuthority?>? {
        return authorities.stream().filter { autority: String? -> StringUtils.isNotBlank(autority) }
                .map { role: String? -> SimpleGrantedAuthority(role) }
                .collect(Collectors.toList())
    }
}