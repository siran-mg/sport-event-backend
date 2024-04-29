package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.event.domain.entities.Organizer
import com.siran.sportevent.event.domain.repositories.FileRepository
import com.siran.sportevent.event.domain.valueobjects.PhotoProfile
import org.springframework.stereotype.Service
import java.util.*

@Service
class UploadOrganizerProfilePhoto(
    private val fileRepository: FileRepository,
) : IUploadOrganizerProfilePhoto {
    override fun execute(input: UploadOrganizerProfilePhotoRequest): PhotoProfile? {
        val organizer = Organizer(userId = UUID.fromString(input.userId))
        organizer.uploadPhotoProfile(fileRepository, input.file)
        return organizer.photoProfile
    }
}