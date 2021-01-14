package com.erp.distribution.sfa

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.erp.distribution.sfa.data.repository.LocalDataSource
import com.erp.distribution.sfa.data.source.local.dao.CocktailDao
import com.erp.distribution.sfa.data.source.local.entity.Cocktail
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.local.entity.FavoritesEntity
import com.erp.distribution.sfa.domain.repository.CocktailRepository
import com.erp.distribution.sfa.domain.usecase.GetCocktailUseCase
import com.erp.distribution.sfa.presentation.base.Resource
import com.erp.distribution.sfa.presentation.utils.ToastHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Gastón Saillén on 03 July 2020
 */

//class MainViewModel @ViewModelInject constructor(
//    private val repository: GetCocktailUseCase,
//    private val toastHelper: ToastHelper,
//    @Assisted private val savedStateHandle: SavedStateHandle
//) : ViewModel() {

class MainViewModel @ViewModelInject constructor(
        private val repository: LocalDataSource
    ) : ViewModel() {

    fun test() {
        Log.d("result", "Awal Oke")
        repository.getFavoritesCocktails()
        viewModelScope.launch {
//                repository.saveFavoriteCocktail(cocktail)
            repository.saveCocktail(CocktailEntity("ab", "http://image","Makanan Riangna","Makan yang ringan banget", "Tidak"))
        }
        Log.d("result", "Akhir Oke")
    }
//    private val currentCocktailName = savedStateHandle.getLiveData<String>("cocktailName", "margarita")
//
//    fun setCocktail(cocktailName: String) {
//        currentCocktailName.value = cocktailName
//    }

//    val fetchCocktailList = currentCocktailName.distinctUntilChanged().switchMap { cocktailName ->
//        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
//            emit(Resource.Loading())
//            try {
//                repository.getCocktailByName(cocktailName).collect {
//                    emit(it)
//                }
//            } catch (e: Exception) {
////                emit(Resource.Failure(e))
//            }
//        }
//    }
//
//    fun saveOrDeleteFavoriteCocktail(cocktail: CocktailEntity) {
//        viewModelScope.launch {
//            if (repository.isCocktailFavorite(cocktail)) {
////                repository.deleteFavoriteCocktail(cocktail)
//                toastHelper.sendToast("Cocktail deleted from favorites")
//            } else {
//                repository.saveFavoriteCocktail(cocktail)
//                toastHelper.sendToast("Cocktail saved to favorites")
//            }
//        }
//    }
//
//    fun getFavoriteCocktails() =
//        liveData<Resource<List<CocktailEntity>>>(viewModelScope.coroutineContext + Dispatchers.IO) {
//            emit(Resource.Loading())
//            try {
//                emitSource(repository.getFavoritesCocktails().map { Resource.Success(it) })
//            } catch (e: Exception) {
//                emit(Resource.Failure(e))
//            }
//        }
//
//    fun deleteFavoriteCocktail(favorites: FavoritesEntity) {
//        viewModelScope.launch {
//            repository.deleteFavoriteCocktail(favorites)
//            toastHelper.sendToast("Cocktail deleted from favorites")
//        }
//    }
//
//    suspend fun isCocktailFavorite(cocktail: CocktailEntity): Boolean =
//        repository.isCocktailFavorite(cocktail)

}