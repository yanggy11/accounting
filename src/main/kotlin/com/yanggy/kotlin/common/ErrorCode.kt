package com.yanggy.kotlin.common

/**
 * @ClassName ErrorCode
 * @Author yanggy
 * @Time 2020/3/26-17:54
 * @Description
 */
const val ERROR_CODE = "000000";
enum class ErrorCode() {

    NORMAL("00000000","success"),
    ERROR(ERROR_CODE + "01","unknown error!"),
    USER_PASSWORD_EMPTY(ERROR_CODE + "02", "username or password must't be empty!!"),
    USER_PASSWORD_ERROR(ERROR_CODE + "03", "username or password is error!!"),
    ;

    lateinit var code:String;
    lateinit var msg:String;

    constructor(code:String, msg:String):this() {
        this.code = code;
        this.msg = msg;
    }
}