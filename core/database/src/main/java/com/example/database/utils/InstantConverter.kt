package com.example.database.utils

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

class InstantConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Instant? {
        return value?.let { Instant.fromEpochMilliseconds(it) }
    }

    @TypeConverter
    fun toTimestamp(instant: Instant?): Long? {
        return instant?.toEpochMilliseconds()
    }
}