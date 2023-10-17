package com.yudhae.submissioncompose.data.local.datasource

import com.yudhae.submissioncompose.core.mapper.toFavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.dao.FavoriteShowDao
import com.yudhae.submissioncompose.data.local.dao.TvShowDao
import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.entity.ShowListingEntity
import com.yudhae.submissioncompose.domain.model.ShowListModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val showDao: TvShowDao,
    private val favoriteShowDao: FavoriteShowDao
) : LocalDataSource {

    override suspend fun deleteFavoriteById(favoriteId: Int) =
        favoriteShowDao.deleteFavoriteById(favoriteId)

    override suspend fun getAllFavoritesFromDb(): List<FavoriteShowListingEntity> =
        favoriteShowDao.getAllFavorites()

    override suspend fun insertShowListingToDb(showList: List<ShowListingEntity>) =
        showDao.insertShowListings(showList)

    override suspend fun insertFavoriteShowToDb(show: ShowListModel) =
        favoriteShowDao.insertFavoriteShow(show.toFavoriteShowListingEntity())

    override suspend fun clearShowListingsFromDb() =
        showDao.clearShowListings()

    override suspend fun getSingleShowFromDB(query: String) =
        showDao.getSingleShowFromDB(query)

    override suspend fun getShowListingFromDb(query: String): List<ShowListingEntity> =
        showDao.searchShowListing(query)
}