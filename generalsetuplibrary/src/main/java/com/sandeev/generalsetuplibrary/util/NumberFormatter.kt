package com.sandeev.generalsetuplibrary.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

object NumberFormatter {

    fun toRupiah(value: Int?, monetaryDecimalSeparator: Boolean): String? {
        val formatSymbol = DecimalFormatSymbols().apply {
            currencySymbol = "Rp"
            groupingSeparator = '.'
        }

        val decimalFormat = (DecimalFormat.getCurrencyInstance(Locale.US) as DecimalFormat).apply {
            decimalFormatSymbols = formatSymbol
            if (!monetaryDecimalSeparator) maximumFractionDigits = 0
        }
        return decimalFormat.format(value)
    }
}