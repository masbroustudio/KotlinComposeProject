package com.yudhae.submissioncompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.yudhae.submissioncompose.core.navigation.BottomNav
import com.yudhae.submissioncompose.core.navigation.NavGraph
import com.yudhae.submissioncompose.presentation.favorite.FavoriteViewModel
import com.yudhae.submissioncompose.presentation.show_listings.ShowListingsViewModel
import com.yudhae.submissioncompose.ui.theme.SubmissionCompose
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubmissionCompose() {
                TvShows()
            }
        }
    }
}

@Composable
fun TvShows() {
    val navController = rememberNavController()
    val   favoriteViewModel: FavoriteViewModel = hiltViewModel()
    val   showListingViewModel: ShowListingsViewModel = hiltViewModel()

    Scaffold(
        bottomBar = { BottomNav(navController = navController) },
        content = { padding -> Column(modifier = Modifier.padding(padding)){
            NavGraph(navController = navController,
                favoriteViewModel=favoriteViewModel,
                showListingViewModel=showListingViewModel
            )
        } },
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxWidth()
    )
}

