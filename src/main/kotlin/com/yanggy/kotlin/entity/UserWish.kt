package com.yanggy.kotlin.entity

import java.util.Date

data class UserWish(
    var id: Long? = null,
    var userId: Long? = null,
    var targetAmount: Double? = null,
    var savedAmount: Double? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null,
    var status: Int? = null,
    var validBeginTime: Date? = null,
    var validEndTime: Date? = null,
    var wish: String? = null,
    var percent: Double? = null
)