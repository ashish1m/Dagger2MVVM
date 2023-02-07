package com.example.dagger2mvvm.di

import androidx.lifecycle.ViewModel
import com.example.dagger2mvvm.viewmodel.MainViewModel
import com.example.dagger2mvvm.viewmodel.SecondaryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun getMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(SecondaryViewModel::class)
    @IntoMap
    abstract fun getSecondaryViewModel(secondaryViewModel: SecondaryViewModel): ViewModel
}