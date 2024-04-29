package com.siran.sportevent.event.domain.repositories

import java.io.File

interface FileRepository {
    fun upload(path: String, file: File): String
}