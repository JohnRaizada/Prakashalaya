package com.example.prakashalay.data.storage

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object Storage {
    private const val nomenclature = "storage"
    private val Context.dataStore by preferencesDataStore("user_data")
    suspend fun save(
        key: String,
        value: String,
        context: Context
    ) {
        val dataStoreKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
        Log.d(nomenclature, "Successfully saved data")
    }

    suspend fun read(
        key: String,
        context: Context
    ): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        Log.d(nomenclature, "Successfully read data")
        return preferences[dataStoreKey]
    }
}