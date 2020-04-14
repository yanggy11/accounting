package com.yanggy.kotlin.controller

import com.yanggy.kotlin.common.enums.ErrorCode
import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.common.ResponseEntityBuilder
import com.yanggy.kotlin.entity.User
import com.yanggy.kotlin.service.IUserService
import org.apache.commons.lang3.StringUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * @ClassName LoginController
 * @Author yanggy
 * @Time 2020/4/1-18:33
 * @Description 用户登录、退出功能
 */

@RestController
@RequestMapping("/auth/")
class LoginController {

    @Resource
    private lateinit var userService:IUserService;

    @PostMapping(value = ["login"])
    fun login(@RequestBody user:User) : ResponseEntity<Any?> {
        return if(StringUtils.isBlank(user.userName) || StringUtils.isBlank(user.password)) {
            ResponseEntityBuilder.buildErrorResponse(ErrorCode.USER_PASSWORD_EMPTY);
        }else {
            userService.login(user)
        }
    }
}