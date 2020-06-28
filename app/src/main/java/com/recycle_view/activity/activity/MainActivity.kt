package com.recycle_view.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recycle_view.R
import com.recycle_view.activity.adapter.Adapter
import com.recycle_view.activity.listener.RecyclerItemClickListener
import com.recycle_view.activity.model.Filme
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView;
    lateinit var filmes : List<Filme>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView);
        filmes = criarFilmes();

        //Configurar o Adapter
        val adapter = Adapter(filmes);

        //Configurar o RecycleView
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.adapter = adapter;

        //Evento de Click
        recyclerView.addOnItemTouchListener(RecyclerItemClickListener(this, recyclerView, object : RecyclerItemClickListener.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val filme : Filme = filmes.get(position);

                Toast.makeText(applicationContext, "Item pressionado: ${filme.titulo}", Toast.LENGTH_LONG).show()
            }

            override fun onItemLongClick(view: View?, position: Int) {
                val filme : Filme = filmes.get(position);

                Toast.makeText(applicationContext, "Click longo: ${filme.titulo}", Toast.LENGTH_LONG).show();
            }

        }))
    }

    private fun criarFilmes() : ArrayList<Filme> {
       val filmes = arrayListOf<Filme>(
           Filme("Homem Aranha","Aventura", "2017"),
           Filme("Mulher Maravilha", "Fantasia", "2018"),
           Filme("Liga da Justiça","Ficção", "2020"),
           Filme("Capitão América - Gerra Cívil", "Aventura/Ficção", "2015"),
           Filme("IT: A Coisa", "Drama/Terror", "2007"),
           Filme("Pica-Pau - O Filme", "Comédia/Animação", "1973"),
           Filme("A Múmia", "Terror", "2014"),
           Filme("A Bela e a Fera", "Romance", "2013"),
           Filme("Mau Malvado Favorito 3", "Comédia", "2006"),
           Filme("Carros 3", "Comédia", "2005"),
           Filme("Pirata do Caribe","Comédia/Ação","2007"),
           Filme("Dois Cara Malucos", "Comédia", "1950"),
           Filme("Batman - O Retorno", "Ação", "2007"),
           Filme("Procurando Neme", "Infantil","2014")
        )
        return filmes;
    }
}
