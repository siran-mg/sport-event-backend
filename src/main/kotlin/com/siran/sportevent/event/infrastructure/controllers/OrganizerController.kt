package com.siran.sportevent.event.infrastructure.controllers

import com.siran.sportevent.event.domain.usecases.commands.CreateOrganizer
import com.siran.sportevent.event.domain.usecases.commands.CreateOrganizerRequest
import com.siran.sportevent.event.domain.usecases.commands.IUploadOrganizerProfilePhoto
import com.siran.sportevent.event.domain.usecases.commands.UploadOrganizerProfilePhotoRequest
import com.siran.sportevent.event.domain.valueobjects.PhotoProfile
import com.siran.sportevent.user.domain.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.io.File
import java.time.Instant

@RestController("/organizers")
class OrganizerController(
    val uploadOrganizerProfilePhoto: IUploadOrganizerProfilePhoto,
    val userRepository: UserRepository,
    val createOrganizer: CreateOrganizer,
) {

    @PostMapping("/upload-photo-profile")
    fun uploadPhotoProfile(@RequestParam("file") multipartFile: MultipartFile): PhotoProfile? {
        return executeUploadPhotoProfile(multipartFile)
    }

    @PostMapping("/register")
    fun registerOrganizer(
        @RequestParam("file") multipartFile: MultipartFile,
        createOrganizerRequest: CreateOrganizerRequest,
    ) {
        val photoProfile = executeUploadPhotoProfile(multipartFile)
        return createOrganizer.execute(
            input = createOrganizerRequest.copy(
                photoProfile = photoProfile?.value ?: ""
            )
        )
    }

    private fun executeUploadPhotoProfile(
        multipartFile: MultipartFile,
    ): PhotoProfile? {
        val authentication = SecurityContextHolder.getContext().authentication

        val tempFile = File.createTempFile(Instant.now().toEpochMilli().toString(), ".png")
        tempFile.deleteOnExit()

        multipartFile.transferTo(tempFile)

        val email = authentication.name
        val user = userRepository.getUserByEmail(email)
            ?: throw ResponseStatusException(HttpStatus.FORBIDDEN)

        val value = uploadOrganizerProfilePhoto.execute(
            UploadOrganizerProfilePhotoRequest(
                userId = user.id.toString(),
                file = tempFile
            )
        )

        tempFile.delete()

        return value
    }
}