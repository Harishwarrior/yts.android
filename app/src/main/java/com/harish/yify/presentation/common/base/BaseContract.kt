package com.harish.yify.presentation.common.base

interface BaseContract {
    interface Presenter<V : View> {
        fun attachView(view: V)
        fun detachView()
        fun destroy()
    }

    interface View
}