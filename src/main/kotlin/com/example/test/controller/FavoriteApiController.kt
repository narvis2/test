package com.example.test.controller

import com.example.test.common.ApiResponse
import com.example.test.domain.favorite.dto.FavoriteRequest
import com.example.test.domain.favorite.service.FavoriteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class FavoriteApiController @Autowired constructor(
    private val favoriteService: FavoriteService
) {
    
    @PostMapping("/favorite")
    fun insertFavorite(
        @Valid
        @RequestBody
        request: FavoriteRequest
    ): ApiResponse<Unit> {
        favoriteService.saveFavorite(request);
        return ApiResponse.success()
    }
}