package com.yanggy.kotlin.entity
import java.util.*

data class PermisionRecord(
    var id: Long? = null,
    var name: String? = null,
    var url: String? = null,
    var type: Int? = null,
    var status: Int = 0,
    var createTime: Date? = null,
    var updateTime: Date? = null,
    var remark: String? = null,
    var permission : String? = null,
    var icon : String? = null,
    var parentId : Long? = null
)