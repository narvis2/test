package com.example.test.domain.favorite.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class FavoriteRequest(
    @field:Email(message = "이메일 형식을 맞춰주세요.")
    @field:NotBlank(message = "이메일을 입력해주세요.")
    val email: String,
    @field:NotBlank(message = "닉네임을 입력해주세요.")
    val nickname: String,
    @field:NotNull
    val myUserId: Long,
)