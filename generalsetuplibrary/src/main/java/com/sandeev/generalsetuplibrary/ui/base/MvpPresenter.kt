package com.sandeev.generalsetuplibrary.ui.base

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V?)

    fun onDetach()

    fun getView(): V?
}