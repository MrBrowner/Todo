package com.example.todo.pref

import android.os.Parcelable
import com.tencent.mmkv.MMKV

object KVStore {
    private val kv: MMKV = MMKV.defaultMMKV()

    fun setKV(k: String, v: Any) {
        if (v is Unit) return
        when (v) {
            is Boolean -> kv.encode(k, v)
            is Int -> kv.encode(k, v)
            is Long -> kv.encode(k, v)
            is Double -> kv.encode(k, v)
            is String -> kv.encode(k, v)
            is ByteArray -> kv.encode(k, v)
            is Parcelable -> kv.encode(k, v)
        }
    }

    fun getKV(k: String, default: Any): Any? {
        return when (default) {
            is Boolean -> kv.decodeBool(k, default)
            is Int -> kv.decodeInt(k, default)
            is Long -> kv.decodeLong(k, default)
            is Double -> kv.decodeDouble(k, default)
            is String -> kv.decodeString(k, default)
            is ByteArray -> kv.decodeBytes(k, default)
            else -> null
        }
    }

    fun hasK(k: String): Boolean = kv.containsKey(k)
}