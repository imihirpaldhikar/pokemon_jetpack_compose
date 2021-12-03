package com.imihirpaldhikar.pokemon.di

import com.imihirpaldhikar.pokemon.data.remote.PokemonAPI
import com.imihirpaldhikar.pokemon.repository.PokemonRepository
import com.imihirpaldhikar.pokemon.utlis.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerPokemonRepository(
        api: PokemonAPI
    ) = PokemonRepository(api = api)

    @Singleton
    @Provides
    fun providePokemonAPI(): PokemonAPI {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonAPI::class.java)
    }
}