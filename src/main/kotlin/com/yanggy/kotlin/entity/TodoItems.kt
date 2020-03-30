package com.yanggy.kotlin.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.math.BigInteger

/**
 * @ClassName TodoItems
 * @Author yanggy
 * @Time 2020/3/26-17:33
 * @Description
 */

@ApiModel(value = "TodoItems", description = "待办事项类")
 class TodoItems : BaseEntity() {
    @ApiModelProperty("用户id")
    lateinit var userId : BigInteger;
    @ApiModelProperty("待办事项")
    lateinit var content : String;
    @ApiModelProperty("类型")
    var type = 0;
    @ApiModelProperty("状态： 0 未办 1 已办")
    var status = 0;
}