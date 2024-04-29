package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase
import com.siran.sportevent.event.domain.valueobjects.PhotoProfile
import java.io.File

data class UploadOrganizerProfilePhotoRequest(
    val userId: String,
    val file: File,
)

interface IUploadOrganizerProfilePhoto : UseCase<UploadOrganizerProfilePhotoRequest, PhotoProfile?>