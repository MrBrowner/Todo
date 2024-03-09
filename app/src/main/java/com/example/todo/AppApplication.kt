package com.example.todo

import android.app.Application
import com.example.todo.di.koinModule
import com.example.todo.pref.KVStore
import com.tencent.mmkv.MMKV
import io.realm.kotlin.Realm
import com.example.todo.logging.ReleaseTree
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


class AppApplication : Application() {

    private val realm: Realm by inject()

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {

                override fun createStackElementTag(element: StackTraceElement): String {
                    return String.format(
                        "%s %s",
                        element.lineNumber,
                        super.createStackElementTag(element),
                    )
                }
            })
        } else {
            // custom tree
            Timber.plant(ReleaseTree())
        }

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@AppApplication)
            modules(koinModule)
        }

        val rootDir = MMKV.initialize(this)
        Timber.e(": $rootDir")

//        KVStore.setKV("app_v", BuildConfig.VERSION_NAME)
        Timber.e("app_v=" + KVStore.getKV("app_v", "").toString())
        Timber.e("realm: %s", realm.configuration.path)
    }
}