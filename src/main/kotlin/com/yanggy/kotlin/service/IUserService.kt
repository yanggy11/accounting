package com.yanggy.kotlin.service

import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.entity.PermisionRecord
import com.yanggy.kotlin.entity.User

interface IUserService {
    /**
    * @Description 用户登录接口
    * @Param user
    * @Author yanggy
    * @Date 2020/4/3-13:48
    * @Return ResponseEntity<Any?>?
    **/
    fun login(user: User): ResponseEntity<Any?>
    /**
    * @Description 获取管理页面菜单
    * @Param permissionRecord
    * @Author yanggy
    * @Date 2020/4/14-16:59
    * @Return
    **/
    fun getMenus(permissionRecord: PermisionRecord): ResponseEntity<Any>?
}