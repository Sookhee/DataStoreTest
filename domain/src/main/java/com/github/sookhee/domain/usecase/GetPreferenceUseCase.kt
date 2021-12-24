package com.github.sookhee.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetPreferenceUseCase {
    operator suspend fun invoke(key: String): Flow<*>
}
