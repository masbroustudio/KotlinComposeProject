package com.yudhae.submissioncompose.presentation.favorite

import com.yudhae.submissioncompose.domain.model.ShowListModel

data class FavoriteUiState(
    val favoriteShows: List<ShowListModel> = emptyList(),
    val id: Int = 0,
    val isLoading: Boolean = false,

    )
