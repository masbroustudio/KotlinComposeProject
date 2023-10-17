package com.yudhae.submissioncompose.data.local.datasource

import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.entity.ShowListingEntity
import com.yudhae.submissioncompose.domain.model.ShowListModel

interface LocalDataSource {

    suspend fun deleteFavoriteById(favoriteId: Int)

    suspend fun getAllFavoritesFromDb(): List<FavoriteShowListingEntity>

    suspend fun insertShowListingToDb(showList: List<ShowListingEntity>)

    suspend fun insertFavoriteShowToDb(show: ShowListModel)

    suspend fun clearShowListingsFromDb()

    suspend fun getSingleShowFromDB(query: String): ShowListingEntity

    suspend fun getShowListingFromDb(query: String): List<ShowListingEntity>


}