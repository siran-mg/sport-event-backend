package com.siran.sportevent.event.domain.entities

import com.siran.sportevent.event.domain.repositories.FileRepository
import com.siran.sportevent.event.domain.valueobjects.OrganizerName
import com.siran.sportevent.event.domain.valueobjects.PhotoProfile
import java.io.File
import java.util.*

data class Organizer(
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    var name: OrganizerName? = null,
    var photoProfile: PhotoProfile? = null,
) {
    fun uploadPhotoProfile(fileRepository: FileRepository, file: File) {
        val value = fileRepository.upload("organizer/$userId/profile-photo", file)
        this.photoProfile = PhotoProfile(value = value)
    }
}
