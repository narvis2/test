package com.example.test.domain.favorite.entity

import com.example.test.domain.base.BaseEntity
import com.example.test.domain.user.entity.Member
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id")
@Entity(name = "favorite")
class Favorite(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Long? = null,
    @Column(nullable = false, length = 30, unique = true)
    var email: String,
    @Column(nullable = false, length = 20, unique = true)
    var nickname: String,
    var memberId: Long? = null,
) : BaseEntity() {
    
    @ManyToOne()
    @JoinColumn(
        name = "memberId",
        insertable = false,
        updatable = false
    )
    var member: Member? = null
}