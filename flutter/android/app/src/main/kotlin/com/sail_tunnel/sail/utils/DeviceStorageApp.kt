package com.sail_tunnel.sail.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkerFactory

@SuppressLint("Registered")
class DeviceStorageApp(context: Context) : Application(), Configuration.Provider {

    init {
        attachBaseContext(context.createDeviceProtectedStorageContext())
    }

    /**
     * Thou shalt not get the REAL underlying application context which would no longer be operating under device
     * protected storage.
     */
    override fun getApplicationContext() = this

    override fun getWorkManagerConfiguration(): Configuration {
        val workerFactory = WorkerFactory()
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}
