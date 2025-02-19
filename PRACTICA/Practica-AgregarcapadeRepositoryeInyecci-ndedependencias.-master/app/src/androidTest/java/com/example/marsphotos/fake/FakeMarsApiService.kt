package com.example.marsphotos.di

import com.example.marsphotos.data.MarsRepository
import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.fake.FakeMarsApiService
import com.example.marsphotos.network.MarsApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class] // Reemplaza el módulo real con este de prueba
)
abstract class TestAppModule {

    @Binds
    @Singleton
    abstract fun bindMarsRepository(
        fakeRepo: NetworkMarsPhotosRepository
    ): MarsRepository

    companion object {
        @Provides
        @Singleton
        fun provideFakeMarsApiService(): MarsApiService {
            return FakeMarsApiService()
        }
    }
}
