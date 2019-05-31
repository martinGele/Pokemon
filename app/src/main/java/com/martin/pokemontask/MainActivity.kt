package com.martin.pokemontask

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.martin.pokemontask.adapters.RecyclerAdapter
import com.martin.pokemontask.viewmodel.DetailActivityViewModel
import com.martin.pokemontask.viewmodel.MainActivityViewModel
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
            val getData = mainActivityViewModel.showDataFromApi()


            recycler_view.apply {

                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter =RecyclerAdapter(getData.results, this@MainActivity)
            }

        }
    }
}
