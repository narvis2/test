package com.example.test.domain.user.entity

enum class Sex(val value: String) {
    MALE("남자"),
    FEMALE("여성")
}

enum class Education(val value: String) {
    MIDDLE("중학교"),
    HIGH("고등학교"),
    UNIVERSITY("대학교"),
    MASTER("석사"),
    DOCTOR("박사")
}

enum class Job(val value: String) {
    PUBLIC("공무원"),
    SMALL("중소기업"),
    MIDDLE("중견기업"),
    BIG("대기업"),
}

enum class Religion(val value: String) {
    CHRISTIAN("교회"),
    BUDDHISM("불교"),
    NONE("없음")
}

enum class Alcohol(val value: String) {
    NOTHING("안마심"),
    SOMETIME("가끔"),
    OFTEN("자주")
}

enum class Smoke(val value: String) {
    NOTHING("안핌"),
    SOMETIME("가끔"),
    OFTEN("자주")
}