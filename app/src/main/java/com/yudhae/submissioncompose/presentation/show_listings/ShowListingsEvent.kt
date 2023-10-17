package com.yudhae.submissioncompose.presentation.show_listings

import com.yudhae.submissioncompose.domain.model.ShowListModel


sealed class ShowListingsEvent {
    object Refresh : ShowListingsEvent()
    object LoadShows : ShowListingsEvent()
    data class OnSearchQueryChange(val query: String) : ShowListingsEvent()
    data class OnFavoriteSelected(val show: ShowListModel) : ShowListingsEvent()
    data class DeleteFavorite(val id: Int) : ShowListingsEvent()

}
