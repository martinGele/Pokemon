package com.martin.pokemontask.adapters


import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.martin.pokemontask.DetailActivity
import com.martin.pokemontask.models.Result
import com.martin.pokemontask.util.NUMBER_OF_POKEMON
import kotlin.coroutines.coroutineContext

class RecyclerAdapter(val results: List<Result>, val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.PokemonHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {


        val v = LayoutInflater.from(parent?.context).inflate(com.martin.pokemontask.R.layout.list_item, parent, false)
        return PokemonHolder(v)
    }

    override fun getItemCount(): Int {

        return results.size
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {


        Log.d("GetUrl", results[position].toString())
        holder.txtTitle?.text = results[position].name


    }

   inner class PokemonHolder(v: View) : RecyclerView.ViewHolder(v) {


        init {
            v.setOnClickListener {

                NUMBER_OF_POKEMON= results[adapterPosition].url
                it.context.startActivity(Intent(context,DetailActivity::class.java))



            }
        }


        val txtTitle = v.findViewById<TextView>(com.martin.pokemontask.R.id.pokemon_name)


    }
}