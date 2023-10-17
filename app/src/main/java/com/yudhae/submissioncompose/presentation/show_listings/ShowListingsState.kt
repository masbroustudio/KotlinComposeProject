package com.yudhae.submissioncompose.presentation.show_listings

import com.yudhae.submissioncompose.data.remote.dto.Image
import com.yudhae.submissioncompose.data.remote.dto.Rating
import com.yudhae.submissioncompose.domain.model.ShowListModel

data class ShowListingsState(
    val shows: List<ShowListModel> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val id: Int = 0,
    val show: ShowListModel = ShowListModel(
        0,
        "",
        "",
        0,
        image = Image(),
        "",
        "",
        "",
        rating = Rating()
    ),
    val error: String = ""
)
