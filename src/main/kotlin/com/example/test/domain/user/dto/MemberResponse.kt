package com.example.test.domain.user.dto

data class MemberResponse(
    val email: String,
    val username: String,
    val nickname: String,
    val sex: String,
    val age: Int,
    val height: Int,
    val weight: Int,
    val birthday: String,
    val phoneNumber: String,
    val lastEducation: String,
    val job: String,
    val religion: String,
    val alcohol: String,
    val smoke: String,
)