package com.example.test.handler.error

import com.example.test.common.ApiResponse
import com.example.test.handler.exception.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {
    
    // ✅ 이메일 중복 오류
    @ExceptionHandler(UserEmailAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409 응답
    fun userEmailAlreadyExistsException(e: UserEmailAlreadyExistsException): ApiResponse<Unit> {
        return ApiResponse.failure(-1005, e.message + "은 중복된 이메일 입니다.")
    }
    
    // ✅ nickname 중복 오류
    @ExceptionHandler(UserNicknameAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    fun userNicknameAlreadyExistsException(e: UserNicknameAlreadyExistsException): ApiResponse<Unit> {
        return ApiResponse.failure(-1006, e.message + "은 중복된 닉네임 입니다.")
    }
    
    @ExceptionHandler(UserEmailAlreadyExistsFavoriteException::class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    fun userEmailAlreadyExistsFavoriteException(e: UserEmailAlreadyExistsFavoriteException): ApiResponse<Unit> {
        return ApiResponse.failure(-1007, e.message + "는 이미 즐겨찾기가 되어있습니다.")
    }
    
    @ExceptionHandler(UserNicknameAlreadyExistsFavoriteException::class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    fun userNicknameAlreadyExistsFavoriteException(e: UserNicknameAlreadyExistsFavoriteException): ApiResponse<Unit> {
        return ApiResponse.failure(-1007, e.message + "님은 이미 즐겨찾기가 되어있습니다.")
    }
    
    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // ✅ 요청한 자원을 찾을 수 없다면, 404 응답
    fun userNotFoundException(e: UserNotFoundException): ApiResponse<Unit> {
        return ApiResponse.failure(-1008, "유저를 찾을 수 없습니다.")
    }
    
    @ExceptionHandler(FavoriteMySelfException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // ✅ 400
    fun favoriteMySelfException(e: FavoriteMySelfException): ApiResponse<Unit> {
        return ApiResponse.failure(-1009, "나 자신은 즐겨찾기할 수 없습니다.")
    }
}