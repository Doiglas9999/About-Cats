package com.example.testeaplicativo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {

    companion object {

        private lateinit var INSTANCE : RacasService

        fun getInstance(): RacasService {

            // instance da api
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.thecatapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                INSTANCE = retrofit.create(RacasService::class.java)


            return INSTANCE
        }
    }


}