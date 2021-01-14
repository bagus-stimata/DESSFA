package com.erp.distribution.sfa.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.local.entity.FavoritesEntity
import io.reactivex.rxjava3.core.Single

/**
 * Created by Gastón Saillén on 07 July 2020
 */

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktailTable")
    fun getAllCoctails(): Single<List<CocktailEntity>>

    @Query("SELECT * FROM favoritesTable")
    suspend fun getAllFavoriteDrinks(): List<FavoritesEntity>

    @Query("SELECT * FROM favoritesTable")
    fun getAllFavoriteDrinksWithChanges(): LiveData<List<FavoritesEntity>>

    @Query("SELECT * FROM cocktailTable WHERE trago_nombre LIKE '%' || :cocktailName || '%'") // This Like operator is needed due that the API returns blank spaces in the name
    suspend fun getCocktails(cocktailName: String): List<CocktailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteCocktail(trago: FavoritesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCocktail(cocktail: CocktailEntity)

    @Delete
    suspend fun deleteFavoriteCoktail(favorites: FavoritesEntity)

    @Query("SELECT * FROM favoritesTable WHERE cocktailId = :cocktailId")
    suspend fun getCocktailById(cocktailId: String): FavoritesEntity?

}