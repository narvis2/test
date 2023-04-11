package com.example.test.domain.mapper

import com.example.test.domain.favorite.entity.Favorite
import com.example.test.domain.user.dto.MemberInfoResponse
import com.example.test.domain.user.dto.MemberRequest
import com.example.test.domain.user.dto.MemberResponse
import com.example.test.domain.user.entity.*

fun MemberRequest.toUserEntity(): Member = Member(
    email = this.email,
    password = this.password,
    username = this.username,
    nickname = this.nickname,
    sex = Sex.valueOf(this.sex),
    age = this.age,
    height = this.height,
    weight = this.weight,
    birthday = this.birthday,
    phoneNumber = this.phoneNumber,
    lastEducation = Education.valueOf(this.lastEducation),
    job = this.job,
    religon = Religion.valueOf(this.religion),
    alcohol = Alcohol.valueOf(this.alcohol),
    smoke = Smoke.valueOf(this.smoke)
)

fun Member.toUserResponse(): MemberResponse = MemberResponse(
    email = this.email,
    username = this.username,
    nickname = this.nickname,
    sex = this.sex.value,
    age = this.age,
    height = this.height,
    weight = this.weight,
    birthday = this.birthday,
    phoneNumber = this.phoneNumber,
    lastEducation = this.lastEducation.value,
    job = this.job.value,
    religion = this.religon.value,
    alcohol = this.alcohol.value,
    smoke = this.smoke.value
)

fun Member.toUserInfoResponse(): MemberInfoResponse = MemberInfoResponse(
    id = this.id,
    email = this.email,
    username = this.username,
    nickname = this.nickname,
    sex = this.sex.value,
    age = this.age,
    height = this.height,
    weight = this.weight,
    birthday = this.birthday,
    phoneNumber = this.phoneNumber,
    lastEducation = this.lastEducation.value,
    job = this.job.value,
    religion = this.religon.value,
    alcohol = this.alcohol.value,
    smoke = this.smoke.value
)