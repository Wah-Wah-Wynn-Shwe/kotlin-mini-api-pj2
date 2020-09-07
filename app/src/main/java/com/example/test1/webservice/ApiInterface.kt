package com.example.test1.webservice

import com.example.test1.Model.item
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

  @GET("top-headlines?")
  abstract fun getMovies(): Call<List<item>>
  }