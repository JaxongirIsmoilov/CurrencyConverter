package uz.gita.jaxongir.currencyconverter.data.mapper

import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.data.sources.remote.response.CurrencyResponseItem

fun CurrencyResponseItem.toData() : CurrencyCommonData = CurrencyCommonData(
    this.Ccy, this.CcyNm_EN, this.CcyNm_UZ, this.CcyNm_RU, this.Code, this.Date, this.Diff, this.Nominal, this.Rate
)