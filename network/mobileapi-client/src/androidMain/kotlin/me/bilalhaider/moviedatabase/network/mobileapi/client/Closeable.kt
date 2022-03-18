@file:JvmName("CloseableJvmKt")

package me.bilalhaider.moviedatabase.network.mobileapi.client

import java.lang.reflect.Method

/**
 * Created by Bilal Haider on 17/03/2022
 */
actual typealias Closeable = java.io.Closeable

@PublishedApi
internal actual fun Throwable.addSuppressedInternal(other: Throwable) {
    AddSuppressedMethod?.invoke(this, other)
}

private val AddSuppressedMethod: Method? by lazy {
    try {
        Throwable::class.java.getMethod("addSuppressed", Throwable::class.java)
    } catch (t: Throwable) {
        null
    }
}