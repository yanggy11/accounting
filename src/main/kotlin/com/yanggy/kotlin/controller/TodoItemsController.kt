package com.yanggy.kotlin.controller

import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.entity.TodoItems
import com.yanggy.kotlin.service.ITodoItemsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
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

@Api("待办事项接口")
@RestController
@RequestMapping("/todos/*")
class TodoItemsController {

    @Resource
    private lateinit var todoItemsService : ITodoItemsService;

    @ApiOperation(value = "新增事项", notes = "参数为待办事项的基本信息")
    @ApiImplicitParam(name = "todoItems",value = "待办事项信息",required = true,dataTypeClass = TodoItems::class)
    @PostMapping(value = ["addItems"], produces = arrayOf("application/json;charset=UTF-8"))
    fun addTodoItems(@RequestBody todoItems: TodoItems) : ResponseEntity<Any> {
       return todoItemsService.addTodoItems(todoItems);
    }

    @ApiOperation(value = "查询待办事项")
    @ApiImplicitParam(name = "todoItems",value = "待办事项信息",required = true,dataTypeClass = TodoItems::class)
    @PostMapping(value = ["getTodoItems"], produces = ["application/json;charset=UTF-8"])
    fun getTodoItems(@RequestBody todoItems: TodoItems) : ResponseEntity<Any> {
        return todoItemsService.getTodoItems(todoItems);
    }

}