package com.yudhae.submissioncompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yudhae.submissioncompose.presentation.aboutme.AboutScreen
import com.yudhae.submissioncompose.presentation.favorite.FavoriteScreen
import com.yudhae.submissioncompose.presentation.favorite.FavoriteViewModel
import com.yudhae.submissioncompose.presentation.show_info.ShowInfoScreen
import com.yudhae.submissioncompose.presentation.show_listings.ShowListingsScreen
import com.yudhae.submissioncompose.presentation.show_listings.ShowListingsViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    showListingViewModel: ShowListingsViewModel = hiltViewModel()
) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            ShowListingsScreen(navController, viewModel = showListingViewModel)
        }
        composable(BottomNavItem.Favorite.screen_route) {
            FavoriteScreen(navController = navController, viewModel = favoriteViewModel)
        }
        composable(BottomNavItem.AboutMe.screen_route) {
            AboutScreen()
        }

        composable(
            "$SHOW_DETAIL_SCREEN/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            ShowInfoScreen(navController = navController)
        }

    }
}