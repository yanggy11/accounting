package com.yanggy.kotlin.config.jwt

import com.yanggy.kotlin.common.CLAIM_KEY_CREATED
import com.yanggy.kotlin.common.CLAIM_KEY_USERNAME
import com.yanggy.kotlin.common.JWT_EXPIRATION_TIME
import com.yanggy.kotlin.common.USER_ROLE
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*
import kotlin.collections.HashMap

/**
 * @ClassName JwtTokenUtil
 * @Author yanggy
 * @Time 2020/4/1-16:36
 * @Description jwt token工具类
 */

@Component
class JwtTokenUtil : Serializable {

    @Value("\${jwt.secret}")
    private  val secret: String? = null;

    /**
     * @Description 获取用户名
     * @Param token
     * @Author yanggy
     * @Date 2020/4/3-13:56
     * @Return String
     **/
    fun getUsernameFromToken(token: String): String? {

        return try {
            val claims = getClaimsFromToken(token)
            claims!!.subject
        } catch (e: Exception) {
            null
        }
    }

    /**
     * @Description 获取用户id
     * @Param token
     * @Author yanggy
     * @Date 2020/4/3-13:56
     * @Return Long
     **/
    fun getUserIdFromToken(token: String): Long? {
        return getClaimsFromToken(token)!!["userId"] as Long?
    }

    /**
    * @Description 获取token生成时间
    * @Param token
    * @Author yanggy
    * @Date 2020/4/3-14:04
    * @Return
    **/
    fun getCreatedDateFromToken(token: String): Date? {
        return try {
            val claims = getClaimsFromToken(token)
            Date((claims!![CLAIM_KEY_CREATED] as Long?)!!)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * @Description 获取token过期时间
     * @Param token
     * @Author yanggy
     * @Date 2020/4/3-14:04
     * @Return
     **/
    fun getExpirationDateFromToken(token: String): Date? {
        return try {
            val claims = getClaimsFromToken(token)
            claims!!.expiration
        } catch (e: Exception) {
            null
        }
    }

    /**
     * @Description 获取token数据
     * @Param token
     * @Author yanggy
     * @Date 2020/4/3-14:04
     * @Return
     **/
    private fun getClaimsFromToken(token: String): Claims? {

        return try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .body
        } catch (e: Exception) {
            null
        }
    }

    private fun generateExpirationDate(): Date? {
        return Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME)
    }

    private fun isTokenExpired(token: String): Boolean? {
        val expiration = getExpirationDateFromToken(token)
        return expiration!!.before(Date())
    }

    private fun isCreatedBeforeLastPasswordReset(created: Date?, lastPasswordReset: Date?): Boolean? {
        return lastPasswordReset != null && created!!.before(lastPasswordReset)
    }

    fun generateToken(userDetails: JwtUser): String? {
        val claims: MutableMap<String?, Any?> = HashMap();
        claims[USER_ROLE] = userDetails.authorities;
        claims[CLAIM_KEY_USERNAME] = userDetails.username;
        claims[CLAIM_KEY_CREATED] = Date()
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }

    fun generateToken(claims: Map<String?, Any?>?) : String {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }

    /**
     * @Description 刷新token
     * @Param token
     * @Author yanggy
     * @Date 2020/4/3-14:04
     * @Return
     **/
    fun refreshToken(token: String): String? {
        return try {
            val claims = getClaimsFromToken(token)
            claims!![CLAIM_KEY_CREATED] = Date()
            generateToken(claims)
        } catch (e: Exception) {
            null
        }
    }

    /**
    * @Description 验证token有效性
    * @Param token, userDetails
    * @Author yanggy
    * @Date 2020/4/3-14:06
    * @Return Boolean
    **/
    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val user: JwtUser = userDetails as JwtUser
        val username = getUsernameFromToken(token)
        val created = getCreatedDateFromToken(token)
        return (username == user.username && !isTokenExpired(token)!!
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())!!)
    }
}