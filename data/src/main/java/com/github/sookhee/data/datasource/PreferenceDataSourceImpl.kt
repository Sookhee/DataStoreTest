package com.github.sookhee.data.datasource

import kotlinx.coroutines.flow.Flow
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
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

    override suspend fun setPreference(key: String, value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
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
