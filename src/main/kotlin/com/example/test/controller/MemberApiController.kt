package com.example.test.controller

import com.example.test.common.ApiResponse
import com.example.test.domain.user.dto.MemberInfoResponse
import com.example.test.domain.user.dto.MemberRequest
import com.example.test.domain.user.dto.MemberResponse
import com.example.test.domain.user.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/v1")
class MemberApiController @Autowired constructor(
    private val memberService: MemberService
) {
    @PostMapping("/users")
    fun saveUser(
        @Valid
        @RequestBody
        request: MemberRequest
    ): ApiResponse<MemberResponse> {
        return ApiResponse.success(memberService.insertUser(request))
    }
    
    @GetMapping("/users")
    fun getUserForEmail(
        
        @Email(message = "이메일 형식을 맞춰주세요.")
        @NotBlank(message = "이메일을 입력해주세요.")
        @RequestParam
        email: String
    ): ApiResponse<MemberInfoResponse> {
        return ApiResponse.success(memberService.getEmailUser(email))
    }
}