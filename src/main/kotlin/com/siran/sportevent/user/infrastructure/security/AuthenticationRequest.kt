package com.siran.sportevent.user.infrastructure.security

data class AuthenticationRequest(
    val email: String,
    val password: String,
)