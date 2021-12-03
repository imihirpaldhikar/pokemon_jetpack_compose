package com.imihirpaldhikar.pokemon.data.remote

import com.imihirpaldhikar.pokemon.data.remote.responses.Pokemon
import com.imihirpaldhikar.pokemon.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonAPI {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int,
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun pokemonInfo(
      @Path("name") name : String
    ) : Pokemon
}