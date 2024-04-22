package com.draja.marsrover

import android.app.Application
import com.draja.marsrover.di.appModule
import com.draja.network.NetworkService
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarsRoverApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MarsRoverApplication)
            modules(appModule)
        }

        NetworkService.createInstance()
    }
}