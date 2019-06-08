package com.martin.pokemontask

import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.martin.pokemontask.viewmodel.DetailActivityViewModel
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailActivity : DaggerActivity() {


    @Inject
    lateinit var detailActivityViewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }


    init {
        CoroutineScope(Dispatchers.Main).launch {

            try {

                val getData = detailActivityViewModel.showDataFromApi()
                ability.text = "abilities: " + getData.abilities[0].ability.name + ", " + getData.abilities[1].ability.name
                forms.text = "forms: " + getData.forms[0].name
                game_index.text = "game index: " + getData.gameIndices[0].gameIndex
                weight.text =getString(R.string.weight)+ getData.weight
                Glide.with(this@DetailActivity).load(getData.sprites.frontShiny).into(image)
            } catch (e: Exception) {
                e.localizedMessage.toString()
                Snackbar.make(root_layout, R.string.something_went_wrong, Snackbar.LENGTH_SHORT
                ).show()


            }
        }
    }

}
