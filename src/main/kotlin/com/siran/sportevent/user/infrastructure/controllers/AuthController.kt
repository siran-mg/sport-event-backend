package com.siran.sportevent.user.infrastructure.controllers

import com.siran.sportevent.user.infrastructure.security.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationService: AuthenticationService,
) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest,
    ): AuthenticationResponse = authenticationService.authentication(authRequest)

    @PostMapping("/refresh")
    fun refreshAccessToken(
        @RequestBody request: RefreshTokenRequest,
    ): TokenResponse {
        try {
            return authenticationService.refreshAccessToken(request.token)
                ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token.")
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token.")
        }


    }
}