package com.siran.sportevent.user.infrastructure.security

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)