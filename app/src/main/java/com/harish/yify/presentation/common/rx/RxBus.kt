package com.harish.yify.presentation.common.rx

import com.jakewharton.rxrelay2.PublishRelay

class RxBus {
    private val bus = PublishRelay.create<Any>().toSerialized()

    fun send(event: Any) = bus.accept(event)

    fun toObservable() = bus

    fun hasObservers() = bus.hasObservers()
}
