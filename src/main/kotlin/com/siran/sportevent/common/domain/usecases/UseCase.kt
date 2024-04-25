package com.siran.sportevent.common.domain.usecases

interface UseCase<I, O> {
    suspend fun execute(input: I): O
}