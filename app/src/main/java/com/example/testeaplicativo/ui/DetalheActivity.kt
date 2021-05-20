package com.example.testeaplicativo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.testeaplicativo.R
import com.example.testeaplicativo.network.response.CatResponse
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        // extras vindo da main activity
        val intent = getIntent()
        val nameCatSelect = intent.getStringExtra("Name")
        val adaptabilityCatSelect = intent.getStringExtra("Adaptability")
        val affectionLevelCatSelect = intent.getStringExtra("Affection_level")
        val childFriendlyCatSelect = intent.getStringExtra("Child_friendly")
        val dogFriendlyCatSelect = intent.getStringExtra("Dog_friendly")
        val energyLevelCatSelect = intent.getStringExtra("Energy_level")
        val healthIssuesCatSelect = intent.getStringExtra("Health_issues")
        val intelligenceCatSelect = intent.getStringExtra("Intelligence")
        val lifeSpanCatSelect = intent.getStringExtra("Life_span")
        val temperamentCatSelect = intent.getStringExtra("Temperament")
        val imageCatSelect = intent.getStringExtra("Image")

        //find da activity detalhe
        var nomeGatoDetalhe      = findViewById<TextView>(R.id.text_nome_detalhe)
        var textoDescricao       = findViewById<TextView>(R.id.text_descricao_detalhe)
        var textoLongevidade     = findViewById<TextView>(R.id.text_longevidade)
        var textoNivelEnergia    = findViewById<TextView>(R.id.text_energia)
        var textAdaptabilidade   = findViewById<TextView>(R.id.text_adaptabilidade)
        var textAfeto            = findViewById<TextView>(R.id.text_afeto)
        var textAmigavelCrianca  = findViewById<TextView>(R.id.text_amigavel_crianca)
        var textAmigavelCachorro = findViewById<TextView>(R.id.text_amigavel_cachorro)
        var textInteligencia     = findViewById<TextView>(R.id.text_inteligencia)
        var textSaude            = findViewById<TextView>(R.id.text_saude)
        var imageGatoDetalhe     = findViewById<ImageView>(R.id.image_detalhe)

        // set texto e imagem das informações do gato escolhido
        textAmigavelCachorro.text = dogFriendlyCatSelect
        nomeGatoDetalhe.text = nameCatSelect
        textoLongevidade.text = healthIssuesCatSelect
        textoNivelEnergia.text = energyLevelCatSelect
        textInteligencia.text = intelligenceCatSelect
        textSaude.text = lifeSpanCatSelect
        textAmigavelCrianca.text = childFriendlyCatSelect
        textAfeto.text = affectionLevelCatSelect
        textAdaptabilidade.text = adaptabilityCatSelect
        textoDescricao.text = temperamentCatSelect
        textoDescricao.text = temperamentCatSelect
        Picasso.get().load(imageCatSelect).into(imageGatoDetalhe)

        Toast.makeText(this, "Voce clicou " + imageCatSelect, Toast.LENGTH_LONG).show()
    }



}