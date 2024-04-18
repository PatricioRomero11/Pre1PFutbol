package com.example.mypre1p

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var main_rv: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_rv = findViewById(R.id.main_rv)
        main_rv.layoutManager = LinearLayoutManager(this)
        val dataSet = getListadoEquipos()
        adapter = Adapter(applicationContext)
        main_rv.adapter = adapter
        adapter.submitList(dataSet)
        adapter.onItemClickListener = {
            /*val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("imagen", it.url)
            startActivity(intent)

             */

        }
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1, "River1","Galllinas","Monumental", "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",Pais.ARGENTINA ),
            Equipo(2, "Boca1","Bosteros","Bombonera","https://en.wikipedia.org/wiki/Boca_Juniors#/media/File:Boca_Juniors_logo18.svg",Pais.ARGENTINA ),
            Equipo(3, "River2","Galllinas","Monumental", "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",Pais.ARGENTINA ),
            Equipo(4, "Boca2","Bosteros","Bombonera","https://en.wikipedia.org/wiki/Boca_Juniors#/media/File:Boca_Juniors_logo18.svg",Pais.ARGENTINA ),
            Equipo(5, "River3","Galllinas","Monumental", "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",Pais.ARGENTINA ),
            Equipo(6, "Boca3","Bosteros","Bombonera","https://en.wikipedia.org/wiki/Boca_Juniors#/media/File:Boca_Juniors_logo18.svg",Pais.ARGENTINA ),
            Equipo(7, "River4","Galllinas","Monumental", "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",Pais.ARGENTINA ),
            Equipo(8, "Boca4","Bosteros","Bombonera","https://en.wikipedia.org/wiki/Boca_Juniors#/media/File:Boca_Juniors_logo18.svg",Pais.ARGENTINA ),
            Equipo(9, "River5","Galllinas","Monumental", "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",Pais.ARGENTINA ),
            Equipo(10, "Boca5","Bosteros","Bombonera","https://en.wikipedia.org/wiki/Boca_Juniors#/media/File:Boca_Juniors_logo18.svg",Pais.ARGENTINA ),

            )
    }


}