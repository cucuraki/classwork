package com.example.hiltexample.data.responsestate



sealed class ResponseState<T> {
    data class Success<T>(val model: T): ResponseState<T>()
    data class Error<T>(val message: String): ResponseState<T>()
}