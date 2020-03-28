package com.yanggy.kotlin.entity

import java.math.BigInteger
import java.util.*

/**
 * @ClassName BaseEntity
 * @Author yanggy
 * @Time 2020/3/26-17:33
 * @Description
 */
open class BaseEntity {
    var id : BigInteger = BigInteger.ZERO;
    var createTime : Date = Date();
    var updateTime : Date = Date();
    var deleteFlag = 0;
}