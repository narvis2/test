package com.example.test.domain.user.service

import com.example.test.domain.mapper.toUserEntity
import com.example.test.domain.mapper.toUserInfoResponse
import com.example.test.domain.mapper.toUserResponse
import com.example.test.domain.user.dto.MemberInfoResponse
import com.example.test.domain.user.dto.MemberRequest
import com.example.test.domain.user.dto.MemberResponse
import com.example.test.domain.user.repository.MemberRepository
import com.example.test.handler.exception.UserEmailAlreadyExistsException
import com.example.test.handler.exception.UserNicknameAlreadyExistsException
import com.example.test.handler.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService @Autowired constructor(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun insertUser(request: MemberRequest): MemberResponse {
        validateSignUpInfo(request)
        val response = memberRepository.save(request.toUserEntity())
        
        return response.toUserResponse()
    }
    
    fun getEmailUser(email: String): MemberInfoResponse {
        return memberRepository.findByEmail(email)?.toUserInfoResponse() ?: throw UserNotFoundException()
    }
    
    /**
     * ✅ 이메일이 존재하는지 체크 👉 존재할 경우 UserEmailAlreadyExistsException 발생
     * ✅ 닉네임이 존재하는지 체크 👉 존재할 경우 UserNicknameAlreadyExistsException 발생
     */
    private fun validateSignUpInfo(request: MemberRequest) {
        if (memberRepository.existsByEmail(request.email))
            throw UserEmailAlreadyExistsException(request.email)
        if (memberRepository.existsByNickname(request.nickname))
            throw UserNicknameAlreadyExistsException(request.nickname)
    }
}