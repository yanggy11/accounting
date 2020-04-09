package com.yanggy.kotlin.controller

import com.yanggy.kotlin.entity.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @ClassName UserController
 * @Author yanggy
 * @Time 2020/4/1-18:22
 * @Description 后台用户、权限管理
 */

@RestController
@RequestMapping("/user/")
class UserController {

    @PostMapping(value = ["/getUsers"])
    fun getUsers(user:User) : List<User> {
        return ArrayList();
    }

}