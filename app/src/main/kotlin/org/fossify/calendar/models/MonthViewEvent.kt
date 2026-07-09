package org.fossify.calendar.models

import android.provider.CalendarContract

data class MonthViewEvent(
    val id: Long,
    val title: String,
    val startTS: Long,
    val endTS: Long,
    val color: Int,
    val startDayIndex: Int,
    val daysCnt: Int,
    val originalStartDayIndex: Int,
    val isAllDay: Boolean,
    val isPastEvent: Boolean,
    val isTask: Boolean,
    val isTaskCompleted: Boolean,
    val isAttendeeInviteDeclined: Boolean,
    val isEventCanceled: Boolean,
    val status: Int = CalendarContract.Events.STATUS_CONFIRMED
) {
    fun shouldStrikeThrough(): Boolean {
        return when {
            status == CalendarContract.Events.STATUS_CANCELED -> true
            isTask -> isTaskCompleted
            else -> false
        }
    }

    fun isTentativeEvent(): Boolean {
        return status == CalendarContract.Events.STATUS_TENTATIVE
    }
}
