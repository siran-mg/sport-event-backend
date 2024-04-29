package com.siran.sportevent.common.domain.usecases

interface UseCase<I, O> {
    fun execute(input: I): O
}