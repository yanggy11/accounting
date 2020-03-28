package com.yanggy.kotlin.service.impl

import com.yanggy.kotlin.common.ErrorCode
import com.yanggy.kotlin.common.ResponseEntity
import com.yanggy.kotlin.common.ResponseEntityBuilder
import com.yanggy.kotlin.dao.TodoItemsMapper
import com.yanggy.kotlin.entity.TodoItems
import com.yanggy.kotlin.service.ITodoItemsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * @ClassName TodoItemsServiceImpl
 * @Author yanggy
 * @Time 2020/3/26-17:40
 * @Description
 */

@Transactional
@Service
class TodoItemsServiceImpl : ITodoItemsService {

    @Resource
    private lateinit var todoItemsMapper : TodoItemsMapper;
    override fun addTodoItems(todoItems: TodoItems): ResponseEntity<Any> {

        return try {
            todoItemsMapper.insert(todoItems);

            ResponseEntityBuilder.buildNormalResponse();
        }catch (exception : Exception) {
            exception.printStackTrace();
            ResponseEntityBuilder.buildErrorResponse(ErrorCode.NORMAL);
        };
    }
}