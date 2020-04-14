package com.yanggy.kotlin.controller

import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.entity.PermisionRecord
import com.yanggy.kotlin.entity.User
import com.yanggy.kotlin.service.IUserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * @ClassName UserController
 * @Author yanggy
 * @Time 2020/4/1-18:22
 * @Description 后台用户、权限管理
 */

@RestController
@RequestMapping("/user/")
class UserController {

    @Resource
    private lateinit var userService : IUserService

    @PostMapping(value = ["/getUsers"])
    fun getUsers(user:User) : List<User> {
        return ArrayList();
    }

    @PostMapping(value = ["/getMenus"])
    fun getMenus(@RequestBody permissionRecord: PermisionRecord) : ResponseEntity<Any>? {
        return userService.getMenus(permissionRecord)
    }

}