package com.github.sookhee.data.datasource

import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {
    suspend fun setPreference(key: String, value: Boolean)
    suspend fun getPreference(key: String): Flow<Boolean?>
}
