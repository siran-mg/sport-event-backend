package com.siran.sportevent.user.domain.usecases.commands

import com.siran.sportevent.user.domain.entities.User
import com.siran.sportevent.user.domain.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserByEmail(
    val userRepository: UserRepository,
) : IGetUserByEmail {
    override fun execute(input: String): User? {
        return userRepository.getUserByEmail(input)
    }
}