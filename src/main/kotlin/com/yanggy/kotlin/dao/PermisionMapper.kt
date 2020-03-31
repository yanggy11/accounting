package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.PermisionRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface PermisionMapper : BaseMapper<PermisionRecord>{
}