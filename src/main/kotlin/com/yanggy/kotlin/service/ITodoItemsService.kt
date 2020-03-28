package com.yanggy.kotlin.service

import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.entity.TodoItems

/**
 * @ClassName ITodoItemsService
 * @Author yanggy
 * @Time 2020/3/26-17:40
 * @Description
 */
interface ITodoItemsService {
    fun addTodoItems(todoItems: TodoItems): ResponseEntity<Any>;
    fun getTodoItems(todoItems: TodoItems): ResponseEntity<Any>;
}