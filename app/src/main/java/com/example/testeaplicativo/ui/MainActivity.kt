package com.example.testeaplicativo.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeaplicativo.R
import com.example.testeaplicativo.model.CatAdapter
import com.example.testeaplicativo.network.ApiService
import com.example.testeaplicativo.network.response.CatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity(), CatAdapter.MyOnClickListener{

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

            //envio da key da api
           ApiService.getInstance().obterListaRacas("dbeba00e-662c-41b6-8cd9-6395fa58b2ef")
                   .enqueue(object : Callback<List<CatResponse>> {
                       override fun onResponse(
                           call: Call<List<CatResponse>>,
                           response: Response<List<CatResponse>>
                       ) {

                           showData(response.body()!!,1)

                       }

                       //tratamento de falhas
                       override fun onFailure(call: Call<List<CatResponse>>, t: Throwable) {
                           Toast.makeText(
                               this@MainActivity,
                               "Falha ao Carregar informações, por favor verifique sua conexao com a internet",
                               Toast.LENGTH_LONG
                           ).show()
                       }

                   })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentAbout = Intent(this, AboutActivity::class.java)
        when (item.itemId){
            R.id.nav_options ->startActivity(intentAbout)
        }


        return super.onOptionsItemSelected(item)
    }


    private fun showData(items: List<CatResponse>,position: Int) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CatAdapter(items,this@MainActivity,position)

        }
    }



    override fun OnClick(items: List<CatResponse>, position: Int) {

        // envio de infrmações do gato escolhido para a activity detalhe
        val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("Name", items[position].name)
            intent.putExtra("Adaptability", items[position].adaptability)
            intent.putExtra("Affection_level", items[position].affection_level)
            intent.putExtra("Child_friendly", items[position].child_friendly)
            intent.putExtra("Dog_friendly", items[position].dog_friendly)
            intent.putExtra("Energy_level", items[position].energy_level)
            intent.putExtra("Health_issues", items[position].health_issues)
            intent.putExtra("Intelligence", items[position].intelligence)
            intent.putExtra("Life_span", items[position].life_span)
            intent.putExtra("Temperament", items[position].temperament)
            intent.putExtra("Image", items[position].image.url)
        startActivity(intent)
    }
}

















