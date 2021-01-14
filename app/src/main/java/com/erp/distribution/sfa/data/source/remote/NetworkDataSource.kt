package com.erp.distribution.sfa.data.source.remote

import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.remote.api.CoctailRetrofit
import com.erp.distribution.sfa.presentation.base.Resource
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

/**
 * Created by Gastón Saillén on 03 July 2020
 */
@ExperimentalCoroutinesApi
class NetworkDataSource @Inject constructor(
    private val webService: CoctailRetrofit
) {
    suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>> =
        callbackFlow {
            offer(
                Resource.Success(
                    webService.getCocktailByName(cocktailName)?.cocktailEntityList ?: listOf()
                )
            )
            awaitClose { close() }
        }

}