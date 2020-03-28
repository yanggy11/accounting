package com.yanggy.kotlin.dao

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.yanggy.kotlin.entity.TodoItems
import org.apache.ibatis.annotations.Mapper

/**
 * @ClassName TodoItemsMapper
 * @Author yanggy
 * @Time 2020/3/26-17:29
 * @Description
 */
@Mapper
interface TodoItemsMapper : BaseMapper<TodoItems>{
    fun getTodoItems(todoItems: TodoItems) : List<TodoItems>;
}