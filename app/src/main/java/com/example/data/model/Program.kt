package com.example.data.model

import java.time.DayOfWeek

enum class DayPattern(val displayName: String) {
    WEEKDAY_MON_FRI("Lunes a Viernes"),
    SATURDAY("Sábados"),
    SUNDAY("Domingos"),
    DAILY("Todos los días");

    fun matches(day: DayOfWeek): Boolean {
        return when (this) {
            DAILY -> true
            WEEKDAY_MON_FRI -> day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY
            SATURDAY -> day == DayOfWeek.SATURDAY
            SUNDAY -> day == DayOfWeek.SUNDAY
        }
    }
}

enum class ProgramGenre(val displayName: String) {
    NOTICIAS("Noticias"),
    MAGAZINE("Magazine"),
    NOVELA("Novela / Serie"),
    ENTRETENIMIENTO("Entretenimiento"),
    DEPORTES("Deportes"),
    CULTURA("Cultura y Tradición"),
    OPINION("Opinión y Debate"),
    INFANTIL("Infantil"),
    CINE("Cine")
}

data class Program(
    val id: String,
    val channelId: String,
    val title: String,
    val description: String,
    val startHour: Int,
    val startMinute: Int,
    val endHour: Int,
    val endMinute: Int,
    val dayPattern: DayPattern,
    val genre: ProgramGenre,
    val presenter: String = "",
    val rating: String = "Apto para todos"
) {
    val startTimeFormatted: String
        get() = "%02d:%02d".format(startHour, startMinute)

    val endTimeFormatted: String
        get() = "%02d:%02d".format(endHour, endMinute)

    val timeRangeFormatted: String
        get() = "$startTimeFormatted - $endTimeFormatted"

    private val startTotalMinutes: Int
        get() = startHour * 60 + startMinute

    private val endTotalMinutes: Int
        get() {
            val end = endHour * 60 + endMinute
            return if (end <= startTotalMinutes) end + 24 * 60 else end
        }

    val durationMinutes: Int
        get() = endTotalMinutes - startTotalMinutes

    fun isCurrentlyPlaying(currentHour: Int, currentMinute: Int, dayOfWeek: DayOfWeek): Boolean {
        if (!dayPattern.matches(dayOfWeek)) return false
        val currentTotalMinutes = currentHour * 60 + currentMinute
        
        return if (endTotalMinutes > 24 * 60) {
            // Program crosses midnight
            currentTotalMinutes >= startTotalMinutes || currentTotalMinutes < (endHour * 60 + endMinute)
        } else {
            currentTotalMinutes in startTotalMinutes until endTotalMinutes
        }
    }

    fun calculateProgress(currentHour: Int, currentMinute: Int): Float {
        var current = currentHour * 60 + currentMinute
        val start = startTotalMinutes
        val end = endTotalMinutes
        if (end > 24 * 60 && current < (endHour * 60 + endMinute)) {
            current += 24 * 60
        }
        if (current < start) return 0f
        if (current >= end) return 1f
        val elapsed = current - start
        val total = end - start
        return (elapsed.toFloat() / total.toFloat()).coerceIn(0f, 1f)
    }

    fun calculateRemainingMinutes(currentHour: Int, currentMinute: Int): Int {
        var current = currentHour * 60 + currentMinute
        val end = endTotalMinutes
        if (end > 24 * 60 && current < (endHour * 60 + endMinute)) {
            current += 24 * 60
        }
        return (end - current).coerceAtLeast(0)
    }
}
