package com.yanggy.kotlin.entity

import com.yanggy.kotlin.common.EMPTY_STRING

data class UserRecord(
    var id: Long? = null,
    var userName: String = EMPTY_STRING,
    var birth: String = EMPTY_STRING,
    var sex: Int = 0,
    var avatar: String = EMPTY_STRING
)