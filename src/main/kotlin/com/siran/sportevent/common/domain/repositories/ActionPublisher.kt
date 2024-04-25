package com.siran.sportevent.common.domain.repositories

import com.siran.sportevent.common.domain.valueobjects.PublishedAction
import com.siran.sportevent.event.domain.valueobjects.EventAction
import org.springframework.stereotype.Service

@Service
interface ActionPublisher {
    fun publish(eventAction: EventAction, data: Any? = null)
    fun getPublishedActions(): ArrayList<PublishedAction>
}