package com.example.todo.di

import com.example.todo.dataRealm.model.Todo
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

val koinModule = module {
    single { Realm.open(RealmConfiguration.create(schema = setOf(Todo::class))) }
}