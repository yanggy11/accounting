package com.yanggy.kotlin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @ClassName TodoItemsServiceImpl
 * @Author yanggy
 * @Time 2020/3/26-17:40
 * @Description the main method of accounting system
 */
@SpringBootApplication
@EnableSwagger2
//@MapperScan("com.anggy.kotlin.dao")
class AccountingApplication

fun main(args: Array<String>) {
    runApplication<AccountingApplication>(*args)
}
