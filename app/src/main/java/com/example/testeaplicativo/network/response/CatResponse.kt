package com.example.testeaplicativo.network.response

import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import com.example.testeaplicativo.ui.MainActivity
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


class CatResponse (

        // documentação da api: https://docs.thecatapi.com/api-reference/breeds/breeds-list

    val name: String,
    val adaptability: String,
    val affection_level: String,
    val child_friendly: String,
    val dog_friendly: String,
    val energy_level: String,
    val health_issues: String,
    val intelligence: String,
    val life_span: String,
    val temperament: String,
    val image: ModeloImage
)