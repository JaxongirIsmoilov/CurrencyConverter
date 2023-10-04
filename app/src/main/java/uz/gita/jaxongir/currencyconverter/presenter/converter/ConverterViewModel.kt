package uz.gita.jaxongir.currencyconverter.presenter.converter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val direction: ConverterDirection
) : ViewModel(), ConverterContract.ViewModel {
    override val uiState = MutableStateFlow(ConverterContract.UIState())

    override fun onEventDispatcher(intent: ConverterContract.Intent) {
        when (intent) {
            ConverterContract.Intent.Back -> {
                viewModelScope.launch {
                    direction.backToMainScreen()
                }
            }

        }
    }
}