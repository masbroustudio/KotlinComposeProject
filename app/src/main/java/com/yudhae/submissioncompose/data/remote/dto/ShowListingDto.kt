package com.yudhae.submissioncompose.data.remote.dto

import com.google.gson.annotations.SerializedName

class ShowListingDto : ArrayList<ShowInfoDto>()

data class Image(
    @SerializedName("medium")
    val medium: String = "",
    @SerializedName("original")
    val original: String = ""
)

data class Rating(
    @SerializedName("average")
    val average: Double = 0.0
)


