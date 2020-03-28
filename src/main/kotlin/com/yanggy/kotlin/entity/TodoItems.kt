package com.yanggy.kotlin.entity

import java.math.BigInteger

/**
 * @ClassName TodoItems
 * @Author yanggy
 * @Time 2020/3/26-17:33
 * @Description
 */
class TodoItems : BaseEntity() {
    lateinit var userId : BigInteger;
    lateinit var content : String;
    var type = 0;
    var status = 0;
}