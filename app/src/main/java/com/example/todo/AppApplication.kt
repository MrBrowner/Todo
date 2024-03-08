package com.example.todo

import android.app.Application
import android.util.Log
import com.example.todo.pref.KVStore
import com.tencent.mmkv.MMKV


class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val rootDir = MMKV.initialize(this)
        Log.e("AppV", "mmkv root: $rootDir")

        KVStore.setKV("app_v", BuildConfig.VERSION_NAME)
        Log.e("AppV", "onCreate: ${KVStore.getKV("app_v", "")}", )
    }
}