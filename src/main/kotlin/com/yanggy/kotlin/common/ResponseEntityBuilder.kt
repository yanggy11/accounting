package com.yanggy.kotlin.common

import com.yanggy.kotlin.common.enums.ErrorCode


/**
 * @ClassName ResponseEntityBuilder
 * @Author yanggy
 * @Time 2020/3/26-17:42
 * @Description
 */
class ResponseEntityBuilder {
    companion object {
        fun <T> buildNormalResponse(data : T?): ResponseEntity<T>{
            return ResponseEntity<T>(RESPONSE_OK, NORMAL_ERROR_CODE, data);
        }

        fun <T> buildNormalResponse() : ResponseEntity<T> {
            return ResponseEntity<T>(RESPONSE_OK, NORMAL_ERROR_CODE);
        }

        fun <T> buildErrorResponse(errorCode: ErrorCode) : ResponseEntity<T> {
            return ResponseEntity<T>(RESPONSE_ERROR, errorCode.msg, errorCode.code);
        }

        fun <T> buildErrorResponse(error:String, msg:String):ResponseEntity<T> {
            return ResponseEntity<T>(RESPONSE_ERROR,null,msg, error);
        }
    }


}