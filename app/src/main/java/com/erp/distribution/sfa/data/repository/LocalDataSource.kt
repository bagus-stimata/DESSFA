package com.erp.distribution.sfa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.erp.distribution.sfa.data.source.local.dao.CocktailDao
import com.erp.distribution.sfa.data.source.local.entity.*
import com.erp.distribution.sfa.presentation.base.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by Gastón Saillén on 10 August 2020
 */

@ExperimentalCoroutinesApi
class LocalDataSource @Inject constructor(private val cocktailDao: CocktailDao) {
    suspend fun saveFavoriteCocktail(cocktail: CocktailEntity) {
        return cocktailDao.saveFavoriteCocktail(cocktail.asFavoriteEntity())
    }

    fun getFavoritesCocktails(): LiveData<List<CocktailEntity>> {
        return cocktailDao.getAllFavoriteDrinksWithChanges().map { it.asDrinkList() }
    }

    suspend fun deleteCocktail(cocktail: CocktailEntity) {
        return cocktailDao.deleteFavoriteCoktail(cocktail.asFavoriteEntity())
    }

    suspend fun saveCocktail(cocktail: CocktailEntity) {
        cocktailDao.saveCocktail(cocktail)
    }

    suspend fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>> {
        return Resource.Success(cocktailDao.getCocktails(cocktailName).asCocktailList())
    }

    suspend fun isCocktailFavorite(cocktail: Cocktail): Boolean {
        return cocktailDao.getCocktailById(cocktail.cocktailId) != null
    }
}