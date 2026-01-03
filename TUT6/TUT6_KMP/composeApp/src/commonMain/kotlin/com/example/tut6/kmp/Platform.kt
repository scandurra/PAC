package com.example.tut6.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform