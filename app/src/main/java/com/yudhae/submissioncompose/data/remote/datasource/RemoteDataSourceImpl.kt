package com.yudhae.submissioncompose.data.remote.datasource

import com.yudhae.submissioncompose.data.remote.apiservice.TvShowApi
import com.yudhae.submissioncompose.data.remote.dto.ShowListingDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: TvShowApi
) : RemoteDataSource {
    override suspend fun getShowListingFromApi(): ShowListingDto = api.getListings()
}