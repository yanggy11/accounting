package com.yanggy.kotlin.entity

data class LabelTypeRecord(
    var id: Long? = null,
    var parentId: Long? = null,
    var labelName: String? = null,
    var remark: String? = null
)