package com.github.sookhee.data.datasource

import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {
    suspend fun <T> setPreference(key: String, value: T)
    suspend fun getPreference(key: String): Flow<Boolean?>
}
