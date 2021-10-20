package com.example.rvsimple_get

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("/people/")
    fun doGetListResources(): Call<List<MyDataItem>>
}