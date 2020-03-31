package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.LabelTypeRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface LabelTypeMapper:BaseMapper<LabelTypeRecord> {
}