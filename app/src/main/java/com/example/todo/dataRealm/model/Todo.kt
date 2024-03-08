package com.example.todo.dataRealm.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Todo: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()

    var isComplete: Boolean = false

    var summary: String = ""
}