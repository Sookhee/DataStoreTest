package com.github.sookhee.domain.usecase

import com.github.sookhee.domain.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPreferenceUseCaseImpl @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): GetPreferenceUseCase {
    override suspend fun invoke(key: String): Flow<Boolean?> {
        return preferenceRepository.getPreference(key)
    }
}