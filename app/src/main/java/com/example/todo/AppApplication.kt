package com.example.todo

import android.app.Application
import android.util.Log
import com.example.todo.dataRealm.model.Todo
import com.example.todo.pref.KVStore
import com.tencent.mmkv.MMKV
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration


class AppApplication : Application() {

    private val config = RealmConfiguration.create(schema = setOf(Todo::class))
    val realm: Realm = Realm.open(config)

    override fun onCreate() {
        super.onCreate()

        val rootDir = MMKV.initialize(this)
        Log.e("mmkv", ": $rootDir")

        KVStore.setKV("app_v", BuildConfig.VERSION_NAME)
        Log.e("AppV", "${KVStore.getKV("app_v", "")}", )
        Log.e("realm", ": ${realm.configuration.path}", )
        Log.e("realm", ": ${realm.configuration.schema}", )
        Log.e("realm", ": ${realm.configuration.name}", )
    }
}