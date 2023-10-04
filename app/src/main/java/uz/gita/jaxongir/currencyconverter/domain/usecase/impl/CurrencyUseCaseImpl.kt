package uz.gita.jaxongir.currencyconverter.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.domain.repository.CurrencyRepository
import uz.gita.jaxongir.currencyconverter.domain.usecase.CurrencyUseCase
import javax.inject.Inject

class CurrencyUseCaseImpl @Inject constructor(
    private val repository: CurrencyRepository
) : CurrencyUseCase {
    override fun getAllCurrency(): Flow<List<CurrencyCommonData>> = repository.getAllData()

}