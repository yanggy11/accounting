package com.yanggy.kotlin.entity

import com.yanggy.kotlin.common.EMPTY_STRING
import java.util.Date

data class PermisionRecord(
    var id: Long = 0,
    var name: String = EMPTY_STRING,
    var url: String = EMPTY_STRING,
    var type: Int = 0,
    var status: Int = 0,
    var createTime: Date? = null,
    var updateTime: Date? = null,
    var remark: String = EMPTY_STRING
)