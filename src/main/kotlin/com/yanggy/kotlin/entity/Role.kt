package com.yanggy.kotlin.entity

import com.yanggy.kotlin.common.EMPTY_STRING

data class Role(
        var id : Long = 0,
        var roleName : String = EMPTY_STRING,
        var remark : String = EMPTY_STRING
)