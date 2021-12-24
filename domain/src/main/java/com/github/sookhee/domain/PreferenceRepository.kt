package com.github.sookhee.domain

import kotlinx.coroutines.flow.Flow


interface PreferenceRepository {
    suspend fun <T> setPreference(key: String, value: T)
    suspend fun getPreference(key: String): Flow<*>
}
