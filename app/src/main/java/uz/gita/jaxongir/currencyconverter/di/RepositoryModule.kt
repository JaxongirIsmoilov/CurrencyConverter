package uz.gita.jaxongir.currencyconverter.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.currencyconverter.data.repository.CurrencyRepositoryImpl
import uz.gita.jaxongir.currencyconverter.domain.repository.CurrencyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindRepository(impl : CurrencyRepositoryImpl) : CurrencyRepository
}