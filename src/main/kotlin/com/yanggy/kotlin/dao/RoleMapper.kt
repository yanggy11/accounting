package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.RoleRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RoleMapper : BaseMapper<RoleRecord>{
}