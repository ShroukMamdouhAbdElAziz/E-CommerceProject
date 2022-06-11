package com.example.e_commerceproject.data.remotesource

import com.example.e_commerceproject.currencyConverter.model.ConverterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val api = "PonwHXimsWL7N3LyigLfHj3E1Rrj0V9R"
interface ConverterApiService {

    @GET("convert")
    suspend fun getconvertedCurrencyvalue(
        @Query("apikey") apikey: String,
        @Query("to") to: String,
        @Query("amount") amount : Long,
        @Query("from") from: String

    ): Response<ConverterModel>
}