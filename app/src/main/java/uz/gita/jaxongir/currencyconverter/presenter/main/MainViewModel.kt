package uz.gita.jaxongir.currencyconverter.presenter.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.domain.usecase.CurrencyUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val direction: MainScreenDirection,
    private val currencyUseCase: CurrencyUseCase
) : MainContract.ViewModel, ViewModel() {

    init {
        currencyUseCase.getAllCurrency().onEach { uiState.emit(MainContract.UIState(it)) }
            .launchIn(viewModelScope)
    }

    override val uiState = MutableStateFlow(MainContract.UIState())
    override var currency1: CurrencyCommonData? = null
    override var currency2: CurrencyCommonData? = null

    override fun eventDispatcher(intent: MainContract.Intent) {
        when (intent) {
            is MainContract.Intent.Click -> {
                if (uiState.value.firstClick.Ccy.isEmpty()) {
                    uiState.update { it.copy(firstClick = intent.data) }
                } else if (uiState.value.firstClick.Ccy != intent.data.Ccy) {
                    viewModelScope.launch {
                        direction.openConverterScreen(uiState.value.firstClick, intent.data)

                    }
                    uiState.update {
                        it.copy(
                            firstClick = CurrencyCommonData(
                                "",
                                "",
                                "",
                                "",
                                " ",
                                "",
                                "",
                                "",
                                ""
                            )
                        )
                    }
                } else {
                    uiState.update {
                        it.copy(
                            firstClick = CurrencyCommonData(
                                "",
                                "",
                                "",
                                "",
                                " ",
                                "",
                                "",
                                "",
                                ""
                            )
                        )
                    }
                }
            }
        }
    }
}