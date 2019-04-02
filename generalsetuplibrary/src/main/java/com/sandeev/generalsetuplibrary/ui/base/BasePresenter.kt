package com.sandeev.generalsetuplibrary.ui.base

class BasePresenter<V: MvpView> : MvpPresenter<V> {

    private var mvpView: V? = null

    override fun onAttach(mvpView: V?) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        mvpView = null
    }

    override fun getView(): V? {
        return mvpView
    }
}