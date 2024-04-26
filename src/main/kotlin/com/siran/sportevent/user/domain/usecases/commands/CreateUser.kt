package com.siran.sportevent.user.domain.usecases.commands

import com.siran.sportevent.user.domain.exceptions.UserAlreadyExistsException
import com.siran.sportevent.user.domain.repositories.UserRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CreateUser(
    val userRepository: UserRepository,
) : ICreateUser {
    override suspend fun execute(input: CreateUserRequest) {
        try {
            userRepository.getUserByEmail(input.email)
        } catch (e: Exception) {
            if (e is EmptyResultDataAccessException) {
                return userRepository.createUser(input.email, input.password)
            }
        }
        throw UserAlreadyExistsException(input.email)
    }
}