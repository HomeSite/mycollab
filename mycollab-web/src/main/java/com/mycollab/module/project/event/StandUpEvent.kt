package com.mycollab.module.project.event

import com.mycollab.vaadin.event.ApplicationEvent

/**
 * @author MyCollab Ltd
 * @since 6.0.0
 */
object StandUpEvent {
    class GotoList(source: Any, val data: Any?) : ApplicationEvent(source)

    class DisplayStandupInProject(source: Any, val data: Int) : ApplicationEvent(source)
}