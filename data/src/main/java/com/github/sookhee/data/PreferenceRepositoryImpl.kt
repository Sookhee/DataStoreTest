package com.github.sookhee.data

import com.github.sookhee.data.datasource.PreferenceDataSource
import com.github.sookhee.domain.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource
) : PreferenceRepository {
    override suspend fun <T> setPreference(key: String, value: T) {
        preferenceDataSource.setPreference(key, value)
    }

    override suspend fun getPreference(key: String): Flow<Boolean?> {
        return preferenceDataSource.getPreference(key)
    }
}
