package com.martin.pokemontask.dependency


import com.martin.pokemontask.DetailActivity
import com.martin.pokemontask.MainActivity
import com.martin.pokemontask.viewmodel.DetailActivityModule
import com.martin.pokemontask.viewmodel.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(DetailActivityModule::class))
    abstract fun bindDetailActivity(): DetailActivity

}
