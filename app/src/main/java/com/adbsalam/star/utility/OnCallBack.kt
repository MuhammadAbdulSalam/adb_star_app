package com.adbsalam.star.utility

interface OnCallBack<T> {
    fun onSuccess(response: T)
    fun onError(message: String, errorCode: Int)
}