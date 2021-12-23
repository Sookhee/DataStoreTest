package com.github.sookhee.data.datasource

import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {
    suspend fun setPreference(key: String, value: Boolean)
    fun getPreference(key: String): Flow<Boolean?>
}