package com.github.sookhee.domain.usecase

import com.github.sookhee.domain.PreferenceRepository
import javax.inject.Inject

class SetPreferenceUseCaseImpl @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) : SetPreferenceUseCase {
    override suspend fun invoke(key: String, value: Boolean) {
        preferenceRepository.setPreference(key, value)
    }
}