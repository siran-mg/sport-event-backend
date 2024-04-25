package com.siran.sportevent.event.domain.valueobjects

class EventName(val value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Event name cannot be empty")
        }
    }
}
