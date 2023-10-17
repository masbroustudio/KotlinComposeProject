package com.yudhae.submissioncompose.domain.repository

import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.entity.ShowListingEntity
import com.yudhae.submissioncompose.data.remote.dto.ShowListingDto
import com.yudhae.submissioncompose.domain.model.ShowListModel
import com.yudhae.submissioncompose.util.Resource
import kotlinx.coroutines.flow.Flow


interface ShowRepository {

    suspend fun getShowListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<ShowListModel>>>

    suspend fun getShowListingFromDb(
        query: String
    ): List<ShowListingEntity>

    suspend fun getShowListingFromApi(): ShowListingDto

    suspend fun clearShowListingsFromDb()

    suspend fun insertShowListingToDb(
        showList: List<ShowListingEntity>
    )

    suspend fun getShowInfo(query: String): Resource<ShowListModel>

    suspend fun insertFavoriteShowToDb(show: ShowListModel)

    suspend fun getFavorites(): Flow<Resource<List<ShowListModel>>>

    suspend fun deleteFavoriteById(favoriteId: Int)

    suspend fun getAllFavoritesFromDb(): List<FavoriteShowListingEntity>

    suspend fun getSingleShowFromDB(query: String): ShowListingEntity
}

