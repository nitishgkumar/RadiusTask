package com.example.radiustask.propertyFilterByFacilities.di

import com.example.radiustask.propertyFilterByFacilities.data.repository.PropertyFacilityRepoImp
import com.example.radiustask.propertyFilterByFacilities.domain.repository.PropertyFacilityRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPropertyFacilityRepo(
        stockRepositoryImpl: PropertyFacilityRepoImp
    ): PropertyFacilityRepo

}