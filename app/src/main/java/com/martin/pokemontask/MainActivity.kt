package com.martin.pokemontask

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.martin.pokemontask.adapters.RecyclerAdapter
import com.martin.pokemontask.viewmodel.DetailActivityViewModel
import com.martin.pokemontask.viewmodel.MainActivityViewModel
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainActivity : DaggerActivity() {


    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    init {
        CoroutineScope(Dispatchers.Main).launch {

            try {


                val getData = mainActivityViewModel.showDataFromApi()


                recycler_view.apply {

                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = RecyclerAdapter(getData.results, this@MainActivity)
                }
            }catch (e: Exception){

                Snackbar.make(
                    root_layout_main, // Parent view
                    "Something went wrong!", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()

            }

        }
    }
}
