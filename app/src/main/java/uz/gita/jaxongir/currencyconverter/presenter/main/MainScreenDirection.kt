package uz.gita.jaxongir.currencyconverter.presenter.main

import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.presenter.converter.ConverterScreen
import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigator
import javax.inject.Inject

interface MainScreenDirection {
    suspend fun openConverterScreen(currency1: CurrencyCommonData, currency2: CurrencyCommonData)
}

class MainScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : MainScreenDirection{
    override suspend fun openConverterScreen(
        currency1: CurrencyCommonData,
        currency2: CurrencyCommonData
    ) {
        appNavigator.navigateWithSave(ConverterScreen(currency1, currency2))
    }

}