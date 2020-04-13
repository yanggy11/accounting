package com.yanggy.kotlin.entity

import java.util.Date

data class UserWishDetails(
    var id: Long? = null,
    var savedAmount: Double? = null,
    var createTime: Date? = null,
    var userId: Long? = null,
    var wishId: Long? = null,
    var updateTime: Date? = null,
    var remark: String? = null
)