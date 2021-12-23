package com.github.sookhee.datastoreexample.di

import android.content.Context
import com.github.sookhee.data.PreferenceRepositoryImpl
import com.github.sookhee.data.datasource.PreferenceDataSource
import com.github.sookhee.data.datasource.PreferenceDataSourceImpl
import com.github.sookhee.domain.PreferenceRepository
import com.github.sookhee.domain.usecase.GetPreferenceUseCase
import com.github.sookhee.domain.usecase.GetPreferenceUseCaseImpl
import com.github.sookhee.domain.usecase.SetPreferenceUseCase
import com.github.sookhee.domain.usecase.SetPreferenceUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object HiltProvider {
    @Singleton
    @Provides
    fun provideGetPreferenceUseCase(preferenceRepository: PreferenceRepository): GetPreferenceUseCase =
        GetPreferenceUseCaseImpl(preferenceRepository)

    @Singleton
    @Provides
    fun provideSetPreferenceUseCase(preferenceRepository: PreferenceRepository): SetPreferenceUseCase =
        SetPreferenceUseCaseImpl(preferenceRepository)

    @Singleton
    @Provides
    fun providePreferenceRepository(preferenceDataSource: PreferenceDataSource): PreferenceRepository =
        PreferenceRepositoryImpl(preferenceDataSource)

    @Singleton
    @Provides
    fun providePreferenceDataSource(@ApplicationContext context: Context): PreferenceDataSource =
        PreferenceDataSourceImpl(context)
}
