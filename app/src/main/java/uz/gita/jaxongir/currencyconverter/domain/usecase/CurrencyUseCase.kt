package uz.gita.jaxongir.currencyconverter.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData

interface CurrencyUseCase {
    fun getAllCurrency(): Flow<List<CurrencyCommonData>>
}