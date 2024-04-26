package com.siran.sportevent.user.domain.exceptions

class UserAlreadyExistsException(val email: String) : Exception("User already exists with email: $email")