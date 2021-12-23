package com.github.sookhee.domain

import kotlinx.coroutines.flow.Flow


interface PreferenceRepository {
    suspend fun setPreference(key: String, value: Boolean)
    fun getPreference(key: String): Flow<Boolean?>
}