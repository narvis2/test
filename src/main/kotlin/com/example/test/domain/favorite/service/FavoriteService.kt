package com.example.test.domain.favorite.service

import com.example.test.domain.favorite.dto.FavoriteRequest
import com.example.test.domain.favorite.mapper.toFavoriteEntity
import com.example.test.domain.favorite.repository.FavoriteRepository
import com.example.test.domain.user.repository.MemberRepository
import com.example.test.handler.exception.FavoriteMySelfException
import com.example.test.handler.exception.UserEmailAlreadyExistsFavoriteException
import com.example.test.handler.exception.UserNicknameAlreadyExistsFavoriteException
import com.example.test.handler.exception.UserNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FavoriteService @Autowired constructor(
    private val favoriteRepository: FavoriteRepository,
    private val memberRepository: MemberRepository
) {
    private val logger = LoggerFactory.getLogger(this::class.java)
    @Transactional
    fun saveFavorite(request: FavoriteRequest) {
        validateFavoriteRequest(request)
        memberRepository.findById(request.myUserId).orElse(null)?.let {
            // ✅ 나 자신을 즐겨찾기 한 경우
            if (request.email == it.email || request.nickname == it.nickname) {
                throw FavoriteMySelfException()
            }
            
            val result = request.toFavoriteEntity()
    
            logger.debug("result 👉 $result")
            
            favoriteRepository.save(result)
        } ?: throw UserNotFoundException()
    }
    
    private fun validateFavoriteRequest(request: FavoriteRequest) {
        if (favoriteRepository.existsByEmail(request.email))
            throw UserEmailAlreadyExistsFavoriteException(request.email)
        
        if (favoriteRepository.existsByNickname(request.nickname))
            throw UserNicknameAlreadyExistsFavoriteException(request.nickname)
    }
    
    fun test() =
        favoriteRepository.findAll()
        
    
}