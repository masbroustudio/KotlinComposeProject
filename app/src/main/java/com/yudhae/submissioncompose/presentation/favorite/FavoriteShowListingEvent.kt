package com.yudhae.submissioncompose.presentation.favorite

sealed class FavoriteShowListingEvent {
    data class OnDeleteSelected(val id: Int) : FavoriteShowListingEvent()
    object LoadFavoriteShows : FavoriteShowListingEvent()

}
