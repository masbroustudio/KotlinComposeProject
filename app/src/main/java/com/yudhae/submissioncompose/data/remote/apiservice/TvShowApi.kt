package com.yudhae.submissioncompose.data.remote.apiservice

import com.yudhae.submissioncompose.data.remote.dto.ShowListingDto
import retrofit2.http.GET

interface TvShowApi {

    @GET(SHOW_END)
    suspend fun getListings(
    ): ShowListingDto

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
        const val SHOW_END = "shows"
    }

}

