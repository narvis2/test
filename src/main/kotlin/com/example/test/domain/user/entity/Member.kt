package com.example.test.domain.user.entity

import com.example.test.domain.base.BaseEntity
import com.example.test.domain.favorite.entity.Favorite
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

// user 는 기본 예약어라 Entity 이름을 user로 하면 Exception 발생 따라서 users 로 변경
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id")
@Entity(name = "member")
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Long? = null,
    @Column(nullable = false, length = 30, unique = true)
    var email: String,
    var password: String?,
    var username: String,
    @Column(nullable = false, length = 20, unique = true)
    var nickname: String,
    @Enumerated(EnumType.STRING)
    var sex: Sex,
    var age: Int,
    var height: Int,
    var weight: Int,
    var birthday: String,
    @Column(name = "phone_number")
    var phoneNumber: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "last_education")
    var lastEducation: Education,
    @Enumerated(EnumType.STRING)
    var job: Job,
    @Enumerated(EnumType.STRING)
    var religon: Religion,
    @Enumerated(EnumType.STRING)
    var alcohol: Alcohol,
    @Enumerated(EnumType.STRING)
    var smoke: Smoke,
) : BaseEntity()