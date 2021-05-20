package com.example.testeaplicativo.network

import com.example.testeaplicativo.network.response.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RacasService {

    //informação nescessario para api
    @GET("/v1/breeds")
    fun obterListaRacas(@Query("x-api-key") apiKey : String):Call<List<CatResponse>>


}