package com.sandeev.generalsetuplibrary.data.repository

interface RepositoryCallback<D> {

    fun onDataLoaded(base: D)

    fun onDataError(message: String?)
}