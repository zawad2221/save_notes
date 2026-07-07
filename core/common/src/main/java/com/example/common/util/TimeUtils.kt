package com.example.common.util

import kotlin.time.Clock
import kotlin.time.Instant

object TimeUtils {
    fun now(): Instant = Clock.System.now()
}
