package com.martin.pokemontask.viewmodel

import androidx.lifecycle.ViewModel
import com.martin.pokemontask.models.PokemonDetails
import com.martin.pokemontask.repository.Repository

class DetailActivityViewModel(private val repository: Repository) : ViewModel() {

    suspend fun showDataFromApi(): PokemonDetails = repository.getDataFromApiDetail().await()
}