package com.yanggy.kotlin.common

/**
 * @ClassName ResponseEntity
 * @Author yanggy
 * @Time 2020/3/26-17:41
 * @Description
 */
class ResponseEntity<T>(var status:String, var error:String) {
    var msg:String = EMPTY_STRING;
    var data:T? = null;

    constructor(status: String, msg: String, error: String) : this(status, error) {
        this.msg = msg;
    }

    constructor(status: String, error: String, data: T?) : this(status, error) {
        this.data = data;
    }

    constructor(status:String,data:T?,msg:String,error:String):this(status,error,data) {
        this.msg = msg;
    }
}