package com.yanggy.kotlin.entity

import com.yanggy.kotlin.common.EMPTY_STRING
import java.util.*

data class User(
        var id: Long? = null,
        var userName: String = EMPTY_STRING,
        var birth: String = EMPTY_STRING,
        var sex: Int = 0,
        var phone: String = EMPTY_STRING,
        var avatar: String = EMPTY_STRING,
        var authorities: List<String> = ArrayList(),
        var password : String = EMPTY_STRING,
        var email : String? = null,
        var lastPasswordResetDate : Date?
) {
    constructor() : this(null, EMPTY_STRING, EMPTY_STRING, 0, EMPTY_STRING, EMPTY_STRING,
            ArrayList<String>(), EMPTY_STRING,null, null) {}
}