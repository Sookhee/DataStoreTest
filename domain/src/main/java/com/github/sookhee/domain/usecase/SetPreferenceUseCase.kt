package com.github.sookhee.domain.usecase

interface SetPreferenceUseCase {
    suspend operator fun <T> invoke(key: String, value: T)
}
