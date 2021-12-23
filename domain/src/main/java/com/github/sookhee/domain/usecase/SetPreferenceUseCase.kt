package com.github.sookhee.domain.usecase

interface SetPreferenceUseCase {
    suspend operator fun invoke(key: String, value: Boolean)
}