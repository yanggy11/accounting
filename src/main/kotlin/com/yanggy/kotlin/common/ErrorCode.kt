package com.yanggy.kotlin.common

/**
 * @ClassName ErrorCode
 * @Author yanggy
 * @Time 2020/3/26-17:54
 * @Description
 */
enum class ErrorCode() {
    NORMAL("00000000","success"),
    ;

    lateinit var code:String;
    lateinit var msg:String;

    constructor(code:String, msg:String):this() {
        this.code = code;
        this.msg = msg;
    }

    companion object {
        var ERROR_CODE = "000000";
    }
}