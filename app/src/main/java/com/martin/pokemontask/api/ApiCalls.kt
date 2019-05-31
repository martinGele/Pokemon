package com.martin.pokemontask.api

import com.martin.pokemontask.models.PokemonDetails
import com.martin.pokemontask.models.Pokemons
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiCalls {

    @GET("api/v2/pokemon/")
    fun getAllPokemons(): Deferred<Pokemons>

    @GET
    fun getIndividualPokemons(@Url url: String): Deferred<PokemonDetails>


}