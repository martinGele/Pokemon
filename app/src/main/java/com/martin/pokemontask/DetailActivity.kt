package com.martin.pokemontask

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.martin.pokemontask.viewmodel.DetailActivityViewModel
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.lifecycle.LifecycleObserver
import com.google.android.material.snackbar.Snackbar


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
                ability.text =
                    "abilities: " + getData.abilities[0].ability.name + ", " + getData.abilities[1].ability.name
                forms.text = "forms: " + getData.forms[0].name
                game_index.text = "game index: " + getData.gameIndices[0].gameIndex
                weight.text = "weight: " + getData.weight
                Glide.with(this@DetailActivity).load(getData.sprites.frontShiny).into(image)
            }catch (e: Exception){
                e.localizedMessage.toString()
                Snackbar.make(
                    root_layout, // Parent view
                    "Something went wrong!", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()


            }
        }
    }

}
