package uz.gita.jaxongir.currencyconverter.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData

interface CurrencyRepository {
    fun getAllData() : Flow<List<CurrencyCommonData>>
}