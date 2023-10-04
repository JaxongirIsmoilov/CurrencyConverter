package uz.gita.jaxongir.currencyconverter.presenter.converter

import kotlinx.coroutines.flow.StateFlow
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData

interface ConverterContract {
    interface ViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent : Intent)

    }

    data class UIState(
        val data1: CurrencyCommonData? = null,
        val data2: CurrencyCommonData? = null


    )

    interface Intent {
        object Back : Intent
    }
}