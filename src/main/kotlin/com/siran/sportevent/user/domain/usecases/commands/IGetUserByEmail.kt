package com.siran.sportevent.user.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase
import com.siran.sportevent.user.domain.entities.User

interface IGetUserByEmail: UseCase<String, User?>