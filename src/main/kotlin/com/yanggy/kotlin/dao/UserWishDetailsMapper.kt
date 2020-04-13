package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.UserWishDetails
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserWishDetailsMapper : BaseMapper<UserWishDetails> {
}