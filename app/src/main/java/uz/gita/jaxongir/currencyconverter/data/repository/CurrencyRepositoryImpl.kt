package uz.gita.jaxongir.currencyconverter.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.jaxongir.currencyconverter.data.mapper.toData
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.data.sources.remote.api.CurrencyApi
import uz.gita.jaxongir.currencyconverter.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi
) : CurrencyRepository {
    override fun getAllData(): Flow<List<CurrencyCommonData>> = flow{
        val response = currencyApi.getAllCurrency()

        if (response.isSuccessful && response.body()!= null){
            emit(response.body()!!.map { it.toData() })
        }
    }.flowOn(Dispatchers.IO)

}