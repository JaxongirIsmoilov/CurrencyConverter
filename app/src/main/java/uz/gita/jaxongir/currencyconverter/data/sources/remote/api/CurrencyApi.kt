package uz.gita.jaxongir.currencyconverter.data.sources.remote.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.jaxongir.currencyconverter.data.sources.remote.response.CurrencyResponse

interface CurrencyApi {

    @GET("json/")
    suspend fun getAllCurrency() : Response<CurrencyResponse>
}