package com.yudhae.submissioncompose.domain.use_case

import com.yudhae.submissioncompose.domain.model.ShowListModel
import com.yudhae.submissioncompose.domain.repository.ShowRepository
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(
    private val repository: ShowRepository
) {
    suspend fun addFavorite(show: ShowListModel) {
        repository.insertFavoriteShowToDb(show)
    }
}