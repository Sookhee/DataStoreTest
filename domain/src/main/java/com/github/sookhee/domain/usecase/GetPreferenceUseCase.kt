package com.github.sookhee.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetPreferenceUseCase {
    operator fun invoke(key: String): Flow<Boolean?>
}