package com.sandeev.generalsetuplibrary.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context

object DialogUtils {

    fun showMessageDialog(context: Context?, message: String?): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context!!)
        builder.let {
            it.setMessage(message)
            it.setPositiveButton(android.R.string.ok) { _, _ -> }
            it.show()
            return it
        }
    }

    fun getProgressDialog(context: Context, layout: Int): Dialog {
        val builder = Dialog(context)
        builder.let {
            it.setCancelable(false)
            it.setContentView(layout)
            return it
        }
    }
}