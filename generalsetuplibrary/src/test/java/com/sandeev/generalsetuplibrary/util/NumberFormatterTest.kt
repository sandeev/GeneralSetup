package com.sandeev.generalsetuplibrary.util

import org.junit.Assert.*
import org.junit.Test

class NumberFormatterTest {

    @Test
    fun formatIsCorrect() {
        val testValue = NumberFormatter.toRupiah(10000, false)
        assertEquals("Rp10.000", testValue)
    }
}