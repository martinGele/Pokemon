package com.martin.pokemontask.viewmodel

import com.martin.pokemontask.repository.Repository
import dagger.Module
import dagger.Provides


@Module
class DetailActivityModule {

    @Provides
    fun provideViewModel(repository: Repository) = DetailActivityViewModel(repository)

}