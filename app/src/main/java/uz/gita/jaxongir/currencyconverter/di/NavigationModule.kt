package uz.gita.jaxongir.currencyconverter.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigationDispatcher
import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigationHandler
import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindAppNavigator(impl : AppNavigationDispatcher) : AppNavigator

    @[Binds Singleton]
    fun bindAppNavigationHandler(impl : AppNavigationDispatcher) : AppNavigationHandler


}