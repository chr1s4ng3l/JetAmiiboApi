package com.tamayo.jetamiiboapi.di

import com.tamayo.jetamiiboapi.data.rest.RepositoryInterface
import com.tamayo.jetamiiboapi.data.rest.RepositoryInterfaceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun providesRepository(repositoryInterfaceImpl: RepositoryInterfaceImpl): RepositoryInterface
}