package com.erp.distribution.sfa.domain.repository

import androidx.lifecycle.LiveData
import com.bumptech.glide.load.engine.Resource
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Gastón Saillén on 16 July 2020
 */
interface CocktailRepository_Asli {
    suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>>
    suspend fun saveFavoriteCocktail(cocktailEntity: CocktailEntity)
    suspend fun isCocktailFavorite(cocktailEntity: CocktailEntity): Boolean
    suspend fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>>
    suspend fun saveCocktail(cocktailEntity: CocktailEntity)
    fun getFavoritesCocktails(): LiveData<List<CocktailEntity>>
    suspend fun deleteFavoriteCocktail(cocktailEntity: CocktailEntity)
}