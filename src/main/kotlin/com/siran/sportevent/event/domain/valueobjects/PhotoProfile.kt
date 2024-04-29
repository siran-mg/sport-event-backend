package com.siran.sportevent.event.domain.valueobjects

class PhotoProfile(val value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Photo profile cannot be empty")
        }
    }
}