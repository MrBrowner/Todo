package com.example.todo

import android.app.Application
import android.util.Log
import com.example.todo.di.koinModule
import com.example.todo.pref.KVStore
import com.tencent.mmkv.MMKV
import io.realm.kotlin.Realm
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class AppApplication : Application() {

    private val realm: Realm by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@AppApplication)
            modules(koinModule)
        }

        val rootDir = MMKV.initialize(this)
        Log.e("mmkv", ": $rootDir")

        KVStore.setKV("app_v", BuildConfig.VERSION_NAME)
        Log.e("AppV", "${KVStore.getKV("app_v", "")}")
        Log.e("realm", ": ${realm.configuration.path}")
    }
}