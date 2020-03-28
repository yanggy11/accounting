package com.yanggy.kotlin.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.math.BigInteger
import java.util.*

/**
 * @ClassName BaseEntity
 * @Author yanggy
 * @Time 2020/3/26-17:33
 * @Description
 */
@ApiModel
open class BaseEntity {
    @ApiModelProperty("主键")
    var id : BigInteger = BigInteger.ZERO;
    @ApiModelProperty("创建时间")
    var createTime : Date = Date();
    @ApiModelProperty("修改时间")
    var updateTime : Date = Date();
    @ApiModelProperty("逻辑删除标志：0 未删除 1 已删除")
    var deleteFlag = 0;
}