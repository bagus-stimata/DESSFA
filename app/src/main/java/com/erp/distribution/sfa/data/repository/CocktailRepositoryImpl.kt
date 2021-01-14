package com.erp.distribution.sfa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.erp.distribution.sfa.data.source.local.dao.CocktailDao
import com.erp.distribution.sfa.data.source.local.entity.*
import com.erp.distribution.sfa.data.source.remote.NetworkDataSource
import com.erp.distribution.sfa.domain.repository.CocktailRepository
import com.erp.distribution.sfa.domain.usecase.GetCocktailUseCase
import com.erp.distribution.sfa.domain.usecase.GetCocktailUseCase_Asal
import com.erp.distribution.sfa.presentation.base.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by Gastón Saillén on 10 August 2020
 */

@ExperimentalCoroutinesApi
@ActivityRetainedScoped
class CocktailRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: CocktailDao
) : CocktailRepository {


    override fun getCocktails(): Single<List<CocktailEntity>>  {
        return localDataSource.getAllCoctails()
    }

    override suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>> =
        callbackFlow {

            offer(getCachedCocktails(cocktailName))

            networkDataSource.getCocktailByName(cocktailName).collect {
                when (it) {
                    is Resource.Success -> {
                        for (cocktail in it.data) {
                            saveCocktail(cocktail.asCocktailEntity())
                        }
                        offer(getCachedCocktails(cocktailName))
                    }
                    is Resource.Failure -> {
                        offer(getCachedCocktails(cocktailName))
                    }
                }
            }
            awaitClose { cancel() }
        }

    override suspend fun saveFavoriteCocktail(cocktailEntity: CocktailEntity) {
//        localDataSource.saveFavoriteCocktail(cocktailEntity)
        return localDataSource.saveFavoriteCocktail(cocktailEntity.asFavoriteEntity())
    }

    override suspend fun isCocktailFavorite(cocktailEntity: CocktailEntity): Boolean =
        localDataSource.getCocktailById(cocktailEntity.cocktailId) != null

    override suspend fun saveCocktail(cocktailEntity: CocktailEntity) {
        localDataSource.saveCocktail(cocktailEntity)
    }

    override suspend fun getFavoritesCocktails(): LiveData<List<CocktailEntity>> {
//        return localDataSource.getFavoritesCocktails()
        return localDataSource.getAllFavoriteDrinksWithChanges().map { it.asDrinkList() }
    }

    override suspend fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>> {
//        return localDataSource.getCachedCocktails(cocktailName)
        return Resource.Success(localDataSource.getCocktails(cocktailName).asCocktailList())

    }

    override suspend fun deleteFavoriteCocktail(favorites: FavoritesEntity) {
        localDataSource.deleteFavoriteCoktail(favorites)
    }

}