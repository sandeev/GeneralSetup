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

    fun formatCurrency(
        value: Int?,
        currencySymbol: String,
        monetaryDecimalSeparator: Char,
        groupingSeparator: Char
    ): String? {
        val formatSymbol = DecimalFormatSymbols().apply {
            this.currencySymbol = currencySymbol
            this.monetaryDecimalSeparator = monetaryDecimalSeparator
            this.groupingSeparator = groupingSeparator
        }
        val decimalFormat = (DecimalFormat.getCurrencyInstance() as DecimalFormat).apply {
            decimalFormatSymbols = formatSymbol
        }
        return decimalFormat.format(value)
    }
}