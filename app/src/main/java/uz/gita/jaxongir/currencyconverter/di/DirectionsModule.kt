package uz.gita.jaxongir.currencyconverter.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.currencyconverter.presenter.converter.ConverterDirection
import uz.gita.jaxongir.currencyconverter.presenter.converter.ConverterScreenDirectionImpl
import uz.gita.jaxongir.currencyconverter.presenter.main.MainScreenDirection
import uz.gita.jaxongir.currencyconverter.presenter.main.MainScreenDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionsModule {

    @[Binds Singleton]
    fun bindMainScreenDirection(impl : MainScreenDirectionImpl) : MainScreenDirection

    @[Binds Singleton]
    fun bindConverterScreenDirection(impl: ConverterScreenDirectionImpl) : ConverterDirection
}