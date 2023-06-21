package com.example.testapp.datasource

import com.example.testapp.model.Jokes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokesService {

    val gson = GsonBuilder().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build().create(JokesApi::class.java)

    suspend fun getJokes(): Call<List<Jokes>> {
        return retrofit.getJokes()
    }

}