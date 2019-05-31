package com.martin.pokemontask.viewmodel


import androidx.lifecycle.ViewModel
import com.martin.pokemontask.models.Pokemons
import com.martin.pokemontask.repository.Repository


class MainActivityViewModel(private val repository: Repository) : ViewModel() {

    suspend fun showDataFromApi(): Pokemons = repository.getDataFromApi().await()
}