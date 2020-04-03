package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User> {
    /*
    * @Description 根据姓名查询用户信息
    * @Param name
    * @Author yanggy
    * @Date 2020/4/2-9:47
    * @Return
    **/
    fun findByName(name: String?): User
    /**
    * @Description 根据用户id用户权限信息
    * @Param id
    * @Author yanggy
    * @Date 2020/4/2-9:48
    * @Return
    **/
    fun getUserRoles(id: Long?) : List<String>
}