package com.erp.distribution.sfa.domain.usecase

import androidx.lifecycle.LiveData
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.local.entity.FavoritesEntity
import com.erp.distribution.sfa.domain.repository.CocktailRepository
import com.erp.distribution.sfa.domain.usecase.base.SingleUseCase
import com.erp.distribution.sfa.presentation.base.Resource
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * An interactor that calls the actual implementation of [PhotoViewModel](which is injected by DI)
 * it handles the response that returns data &
 * contains a list of actions, event steps
 */
class GetCocktailUseCase @Inject constructor(private val repository: CocktailRepository) : SingleUseCase<List<CocktailEntity>>() {

    override fun buildUseCaseSingle(): Single<List<CocktailEntity>> {
        return repository.getCocktails()
    }

//    suspend fun getCocktails(): Single<List<CocktailEntity>> {
//        return repository.getCocktails()
//    }

    suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<CocktailEntity>>> {
        return repository.getCocktailByName(cocktailName)
    }
    suspend fun saveFavoriteCocktail(cocktailEntity: CocktailEntity){
        return repository.saveFavoriteCocktail(cocktailEntity)
    }
    suspend fun isCocktailFavorite(cocktailEntity: CocktailEntity): Boolean {
        return repository.isCocktailFavorite(cocktailEntity)
    }
    suspend fun getCachedCocktails(cocktailName: String): Resource<List<CocktailEntity>> {
        return repository.getCachedCocktails(cocktailName)
    }
    suspend fun saveCocktail(cocktailEntity: CocktailEntity){
        return repository.saveCocktail(cocktailEntity)
    }
    suspend fun getFavoritesCocktails(): LiveData<List<CocktailEntity>> {
        return repository.getFavoritesCocktails()
    }
    suspend fun deleteFavoriteCocktail(favorites: FavoritesEntity){
        return repository.deleteFavoriteCocktail(favorites)
    }

}