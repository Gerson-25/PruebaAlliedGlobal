package com.example.testapp.model

import java.util.Date

data class Jokes(
    val categories: List<Any>,
    val createdAt: Date,
    val iconUrl: String,
    val id: String,
    val updatedAt: Date,
    val url: String,
    val value: String
)