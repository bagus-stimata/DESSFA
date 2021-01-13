package com.erp.distribution.sfa.data.source.remote.api

import com.erp.distribution.sfa.data.source.local.entity.CocktailList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Gastón Saillén on 04 July 2020
 */
interface CoctailRetrofit {
    @GET("search.php")
    suspend fun getCocktailByName(@Query(value = "s") tragoName: String): CocktailList?
}