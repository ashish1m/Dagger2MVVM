package com.example.dagger2mvvm

import android.app.Application
import com.example.dagger2mvvm.di.ApplicationComponent
import com.example.dagger2mvvm.di.DaggerApplicationComponent

class Dagger2MVVMApp : Application() {

    companion object {
        lateinit var mInstance: Dagger2MVVMApp
            private set
    }

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        mInstance = this
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}