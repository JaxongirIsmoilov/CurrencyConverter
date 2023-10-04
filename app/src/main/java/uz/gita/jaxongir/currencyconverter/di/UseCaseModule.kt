package uz.gita.jaxongir.currencyconverter.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.currencyconverter.domain.usecase.CurrencyUseCase
import uz.gita.jaxongir.currencyconverter.domain.usecase.impl.CurrencyUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun bindCurrencyUseCase(impl : CurrencyUseCaseImpl) : CurrencyUseCase
}