package com.example.test.domain.favorite.entity

import com.example.test.domain.base.BaseEntity
import com.example.test.domain.user.entity.Member
import javax.persistence.*

@Entity
class Favorite(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    var id: Long? = null,
    @Column(nullable = false, length = 30, unique = true)
    var email: String,
    @Column(nullable = false, length = 20, unique = true)
    var nickname: String,
    var memberId: Long? = null,
) : BaseEntity()