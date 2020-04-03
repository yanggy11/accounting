package com.yanggy.kotlin.entity

import com.yanggy.kotlin.common.EMPTY_STRING

data class RoleRecord(
    var id: Long? = null,
    var roleName: String = EMPTY_STRING,
    var remark: String = EMPTY_STRING
)