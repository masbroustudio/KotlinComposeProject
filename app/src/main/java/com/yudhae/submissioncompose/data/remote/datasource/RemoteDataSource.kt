package com.yudhae.submissioncompose.data.remote.datasource

import com.yudhae.submissioncompose.data.remote.dto.ShowListingDto

interface RemoteDataSource {

    suspend fun getShowListingFromApi(): ShowListingDto
}