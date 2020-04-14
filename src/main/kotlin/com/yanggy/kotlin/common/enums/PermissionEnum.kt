package com.yanggy.kotlin.common.enums

/**
 * @ClassName PermissionEnum
 * @Author yanggy
 * @Time 2020/4/14-18:06
 * @Description
 */
enum class PermissionEnum() {
    PER_MENU(0,"菜单类型"),
    PER_BUTTON(1,"buton类型"),
    ;

    var code:Int = 0;
    lateinit var msg:String;

    constructor(code:Int, msg:String):this() {
        this.code = code;
        this.msg = msg;
    }
}