package com.martin.pokemontask.viewmodel

import com.martin.pokemontask.repository.Repository
import com.martin.pokemontask.viewmodel.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository) = MainActivityViewModel(repository)
}