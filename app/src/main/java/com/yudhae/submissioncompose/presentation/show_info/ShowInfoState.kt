package com.yudhae.submissioncompose.presentation.show_info

import com.yudhae.submissioncompose.domain.model.ShowListModel

data class ShowInfoState(
    val show: ShowListModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)