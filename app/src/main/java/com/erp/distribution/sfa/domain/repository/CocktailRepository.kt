package com.erp.distribution.sfa.domain.repository

import androidx.lifecycle.LiveData
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.presentation.base.Resource
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow


/**
 * To make an interaction between [PhotoRepositoryImp] & [GetPhotosUseCase]
 * */
interface CocktailRepository {
    fun getCocktails(): Single<List<CocktailEntity>>
    fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>>
    fun saveFavoriteCocktail(cocktailEntity: CocktailEntity)
    fun isCocktailFavorite(cocktailEntity: CocktailEntity): Boolean
    fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>>
    fun saveCocktail(cocktailEntity: CocktailEntity)
    fun getFavoritesCocktails(): LiveData<List<CocktailEntity>>
    fun deleteFavoriteCocktail(cocktailEntity: CocktailEntity)
}