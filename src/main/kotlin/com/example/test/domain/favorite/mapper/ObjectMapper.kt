package com.example.test.domain.favorite.mapper

import com.example.test.domain.favorite.dto.FavoriteRequest
import com.example.test.domain.favorite.entity.Favorite

fun FavoriteRequest.toFavoriteEntity(): Favorite = Favorite(email = this.email, nickname = this.nickname, memberId = this.myUserId)