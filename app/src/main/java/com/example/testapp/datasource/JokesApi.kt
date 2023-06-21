package com.example.testapp.datasource

import com.example.testapp.model.Jokes
import retrofit2.Call
import retrofit2.http.GET

interface JokesApi {

    @GET(value = "jokes/random")
    fun getJokes(): Call<List<Jokes>>
}