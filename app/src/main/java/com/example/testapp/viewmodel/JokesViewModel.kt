package com.example.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.datasource.JokesService
import com.example.testapp.model.Jokes
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokesViewModel: ViewModel() {

    val jokesService = JokesService()

    private var _jokes: MutableLiveData<List<Jokes>> = MutableLiveData()
    val jokes: LiveData<List<Jokes>> = _jokes

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    fun  getJokes() {
        viewModelScope.launch {
            val response = jokesService.getJokes()
            response.enqueue(object : Callback<List<Jokes>>{
                override fun onResponse(call: Call<List<Jokes>>, response: Response<List<Jokes>>) {
                    _jokes.value = response.body()
                }

                override fun onFailure(call: Call<List<Jokes>>, t: Throwable) {
                    _error.value = "Ocurrio un error"
                }

            })
        }
    }
}