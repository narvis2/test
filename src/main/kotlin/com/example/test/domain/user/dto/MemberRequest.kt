package com.example.test.domain.user.dto

import com.example.test.domain.user.entity.Job
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MemberRequest(
    @field:Email(message = "이메일 형식을 맞춰주세요.")
    @field:NotBlank(message = "이메일을 입력해주세요.")
    val email: String,
    @field:NotBlank(message = "비밀번호를 입력해주세요.")
    val password: String,
    @field:NotBlank(message = "유저이름을 입력해주세요.")
    val username: String,
    @field:NotBlank(message = "닉네임을 입력해주세요.")
    val nickname: String,
    @field:NotNull(message = "성별을 입력해주세요.")
    val sex: String,
    @field:NotNull(message = "나이를 입력해주세요.")
    val age: Int,
    @field:NotNull(message = "키를 입력해주세요.")
    val height: Int,
    @field:NotNull(message = "몸무게 입력해주세요.")
    val weight: Int,
    @field:NotBlank(message = "생일을 입력해주세요.")
    val birthday: String,
    @field:NotBlank(message = "핸드폰 번호를 입력해주세요.")
    val phoneNumber: String,
    @field:NotBlank(message = "최종학력을 입력해주세요.")
    val lastEducation: String,
    @field:NotNull(message = "직업을 입력해주세요.")
    val job: Job,
    @field:NotNull(message = "종교를 입력해주세요.")
    val religion: String,
    @field:NotNull(message = "음주 여부를 입력해주세요.")
    val alcohol: String,
    @field:NotNull(message = "흡연 여부를 입력해주세요.")
    val smoke: String,
)