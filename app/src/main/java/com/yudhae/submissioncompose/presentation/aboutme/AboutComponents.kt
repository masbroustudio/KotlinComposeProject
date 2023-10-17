package com.yudhae.submissioncompose.presentation.aboutme

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.ui.graphics.vector.ImageVector
import com.yudhae.submissioncompose.R

class AboutComponents {
    fun getAllData(): List<AboutSettingListModel> {
        return listOf(
            AboutSettingListModel(
                imageVector = Icons.Default.Person,
                contentDescription = R.string.about,
                text = R.string.about_text
            ),
            AboutSettingListModel(
                imageVector = Icons.Default.QuestionMark,
                contentDescription = R.string.version_,
                text = R.string.version_0_1
            )
        )
    }
}

data class AboutSettingListModel(
    val imageVector: ImageVector,
    @StringRes val contentDescription: Int,
    @StringRes val text: Int
)