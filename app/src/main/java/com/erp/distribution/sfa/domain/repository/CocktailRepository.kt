package com.erp.distribution.sfa.domain.repository

import androidx.lifecycle.LiveData
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.local.entity.FavoritesEntity
import com.erp.distribution.sfa.presentation.base.Resource
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

/**
 * Created by Gastón Saillén on 16 July 2020
 */
interface CocktailRepository {
    fun getCocktails(): Single<List<CocktailEntity>>
    suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>>
    suspend fun saveFavoriteCocktail(cocktailEntity: CocktailEntity)
    suspend fun isCocktailFavorite(cocktailEntity: CocktailEntity): Boolean
    suspend fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>>
    suspend fun saveCocktail(cocktailEntity: CocktailEntity)
    suspend fun getFavoritesCocktails(): LiveData<List<CocktailEntity>>
    suspend fun deleteFavoriteCocktail(favorites: FavoritesEntity)
}