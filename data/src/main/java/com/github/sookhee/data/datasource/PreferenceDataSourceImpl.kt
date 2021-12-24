package com.github.sookhee.data.datasource

import kotlinx.coroutines.flow.Flow
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PreferenceDataSource {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "datastore_pref")

    override suspend fun <T> setPreference(key: String, value: T) {
        context.dataStore.edit { preferences ->
            when (value) {
                is Boolean -> preferences[booleanPreferencesKey(key)] = value
                is Double -> preferences[doublePreferencesKey(key)] = value
                is Float -> preferences[floatPreferencesKey(key)] = value
                is Int -> preferences[intPreferencesKey(key)] = value
                is Long -> preferences[longPreferencesKey(key)] = value
                else -> preferences[stringPreferencesKey(key)] = value.toString()
            }
        }
    }

    override suspend fun getPreference(key: String): Flow<Boolean?> {
        return context.dataStore.data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map { preferences ->
                preferences[booleanPreferencesKey(key)]
            }
    }
}
