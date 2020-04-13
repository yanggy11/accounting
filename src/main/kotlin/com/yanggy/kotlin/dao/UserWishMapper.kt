package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.UserWish
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserWishMapper : BaseMapper<UserWish>{
}