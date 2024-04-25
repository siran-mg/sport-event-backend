package com.siran.sportevent.common.infrastructure

import com.siran.sportevent.common.domain.repositories.ActionPublisher
import com.siran.sportevent.common.domain.valueobjects.PublishedAction
import com.siran.sportevent.event.domain.valueobjects.EventAction
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class InMemoryActionPublisher: ActionPublisher {
    private val publishedActions: ArrayList<PublishedAction> = ArrayList()

    override fun publish(eventAction: EventAction, data: Any?): Unit {
        publishedActions.add(
            PublishedAction(
                eventAction = eventAction,
                publishedAt = LocalDate.now(),
                data = data
            )
        )
    }
    override fun getPublishedActions(): ArrayList<PublishedAction> {
        return publishedActions
    }
}