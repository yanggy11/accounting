package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.RolePermissionRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RolePermissionMapper : BaseMapper<RolePermissionRecord>{
}