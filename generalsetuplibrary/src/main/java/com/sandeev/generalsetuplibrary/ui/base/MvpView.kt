package com.sandeev.generalsetuplibrary.ui.base

interface MvpView {

    fun onShowMessageDialog(message: String?)

    fun onShowMessageToast(message: String?)

    fun onShowProgressDialog(show: Boolean)
}