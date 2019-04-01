package com.sandeev.generalsetuplibrary.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object NumberFormatter {

    fun toRupiah(value: Int?): String? {
        val formatSymbol = DecimalFormatSymbols().apply {
            currencySymbol = "Rp"
            monetaryDecimalSeparator = ','
            groupingSeparator = '.'
        }
        val decimalFormat = (DecimalFormat.getCurrencyInstance() as DecimalFormat).apply {
            decimalFormatSymbols = formatSymbol
        }
        return decimalFormat.format(value)
    }
}