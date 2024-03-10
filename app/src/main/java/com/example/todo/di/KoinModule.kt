package com.example.todo.di

import com.example.todo.dataOBox.network.AnimeQuoteService
import com.example.todo.dataOBox.repo.AnimeQuoteRepoImpl
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.domain.model.MyObjectBox
import com.example.todo.domain.repo.AnimeQuoteRepo
import com.example.todo.vm.AnimeQuoteVM
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import io.objectbox.BoxStore
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val koinModule = module {
    // db setup: Object-Box
    single<BoxStore> {
        MyObjectBox.builder()
            .androidContext(androidContext())
            .build()
    }

    single<Json> {
        Json { ignoreUnknownKeys = true }
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://animechan.xyz/api/")
            .addConverterFactory(get<Json>().asConverterFactory("application/json".toMediaType())) // should add it at last
            .build()
    }

    single<AnimeQuoteService> {
        get<Retrofit>().create(AnimeQuoteService::class.java)
    }

    single<AnimeQuoteRepo> { AnimeQuoteRepoImpl(get<AnimeQuoteService>()) }

    viewModel {
        AnimeQuoteVM(
            get<BoxStore>().boxFor(AnimeQuote::class.java),
            get<AnimeQuoteRepo>()
        )
    }

}