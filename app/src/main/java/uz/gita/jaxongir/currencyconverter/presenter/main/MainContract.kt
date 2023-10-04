package uz.gita.jaxongir.currencyconverter.presenter.main

import kotlinx.coroutines.flow.StateFlow
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData

interface MainContract {

    interface ViewModel{
        val uiState: StateFlow<UIState>
        fun eventDispatcher(intent: Intent)
        var currency1: CurrencyCommonData?
        var currency2: CurrencyCommonData?
    }

    data class UIState(
        val currencyList : List<CurrencyCommonData> = listOf(),
        val firstClick : CurrencyCommonData = CurrencyCommonData("", "","","","","","","","")
    )

    interface Intent{
        data class Click(
            val data : CurrencyCommonData
        ) : Intent
    }
}