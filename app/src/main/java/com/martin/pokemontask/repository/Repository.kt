package com.martin.pokemontask.repository

import com.martin.pokemontask.api.ApiCalls
import com.martin.pokemontask.models.PokemonDetails

import com.martin.pokemontask.models.Pokemons
import com.martin.pokemontask.models.Result
import com.martin.pokemontask.util.NUMBER_OF_POKEMON
import kotlinx.coroutines.Deferred
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiCalls) {

    fun getDataFromApi(): Deferred<Pokemons> = apiService.getAllPokemons()

    fun getDataFromApiDetail(): Deferred<PokemonDetails> = apiService.getIndividualPokemons(NUMBER_OF_POKEMON)

}