package com.imihirpaldhikar.pokemon.repository

import com.imihirpaldhikar.pokemon.data.remote.PokemonAPI
import com.imihirpaldhikar.pokemon.data.remote.responses.Pokemon
import com.imihirpaldhikar.pokemon.data.remote.responses.PokemonList
import com.imihirpaldhikar.pokemon.utlis.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonAPI
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (error: Exception) {
            return Resource.Error(message = "An error occurred")
        }

        return Resource.Success(data = response)
    }

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.pokemonInfo(pokemonName)
        } catch (error: Exception) {
            return Resource.Error(message = "An error occurred")
        }

        return Resource.Success(data = response)
    }
}