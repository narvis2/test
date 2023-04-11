package com.example.test.domain.favorite.repository

import com.example.test.domain.favorite.entity.Favorite
import org.springframework.data.jpa.repository.JpaRepository

interface FavoriteRepository : JpaRepository<Favorite, Long> {
    fun existsByEmail(email: String): Boolean
    fun existsByNickname(nickname: String): Boolean
    fun getFavoritesByMemberId(memberId: Long): List<Favorite>
}