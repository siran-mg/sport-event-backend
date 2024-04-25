package com.siran.sportevent.user.infrastructure.security

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,
)
