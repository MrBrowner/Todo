package com.example.todo.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R
import com.example.todo.dataOBox.network.model.AnimeQuoteNetworkModel
import com.example.todo.vm.MainVM
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val vm: MainVM by viewModels<MainVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.e("onCreate: " + vm.t1)

        val one = AnimeQuoteNetworkModel("life", "mE", "XyX")
        Timber.tag("a1").e(Json.encodeToString(one))

        val two = """{"anime":"life","character":"mE","quote":"XyX"}"""
        Timber.tag("a2").e(Json.decodeFromString<AnimeQuoteNetworkModel>(two).toString())
    }
}