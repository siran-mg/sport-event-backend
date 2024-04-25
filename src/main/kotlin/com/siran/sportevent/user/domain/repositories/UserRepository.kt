package com.siran.sportevent.user.domain.repositories

import com.siran.sportevent.user.domain.entities.User

interface UserRepository {
    fun createUser(email: String, password: String)
    fun getUserByEmail(email: String): User?
}