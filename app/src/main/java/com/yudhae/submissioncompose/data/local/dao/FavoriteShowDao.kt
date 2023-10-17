package com.yudhae.submissioncompose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity

@Dao
interface FavoriteShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteShow(show: FavoriteShowListingEntity)

    @Query("SELECT * FROM favorite_show_listing_table")
    suspend fun getAllFavorites(): List<FavoriteShowListingEntity>

    @Query("DELETE FROM favorite_show_listing_table WHERE id = :favoriteId")
    suspend fun deleteFavoriteById(favoriteId: Int)

}