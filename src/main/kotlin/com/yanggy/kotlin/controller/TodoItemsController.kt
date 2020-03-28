package com.yanggy.kotlin.controller

import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.entity.TodoItems
import com.yanggy.kotlin.service.ITodoItemsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * @ClassName TodoItemsController
 * @Author yanggy
 * @Time 2020/3/26-17:41
 * @Description
 */

@RestController
@RequestMapping("/todos/*")
class TodoItemsController {

    @Resource
    private lateinit var todoItemsService : ITodoItemsService;

    @PostMapping(value = ["addItems"], produces = arrayOf("application/json;charset=UTF-8"))
    public fun addTodoItems(@RequestBody todoItems: TodoItems) : ResponseEntity<Any> {
       return todoItemsService.addTodoItems(todoItems);
    }
}