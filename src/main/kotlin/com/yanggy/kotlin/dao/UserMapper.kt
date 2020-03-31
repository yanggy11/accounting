package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.UserRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper:BaseMapper<UserRecord> {
}