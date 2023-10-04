package uz.gita.jaxongir.currencyconverter.presenter.converter

import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigator
import javax.inject.Inject

interface ConverterDirection {
    suspend fun backToMainScreen()
}

class ConverterScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : ConverterDirection {
    override suspend fun backToMainScreen() {
        appNavigator.back()
    }

}