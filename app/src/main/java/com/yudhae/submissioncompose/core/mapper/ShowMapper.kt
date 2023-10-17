package com.yudhae.submissioncompose.core.mapper

import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.entity.ShowListingEntity
import com.yudhae.submissioncompose.data.remote.dto.ShowInfoDto
import com.yudhae.submissioncompose.domain.model.ShowListModel


fun ShowListingEntity.toShowListing(): ShowListModel {
    return ShowListModel(
        id = id!!,
        name = name,
        type = type,
        runtime = runtime,
        image = image,
        status = status,
        summary = summary,
        premiered = premiered,
        rating = rating

    )
}

fun ShowListModel.toShowListingEntity(): ShowListingEntity {
    return ShowListingEntity(
        id = id,
        name = name,
        type = type,
        runtime = runtime,
        image = image,
        status = status,
        summary = summary,
        premiered = premiered,
        rating = rating
    )
}

fun ShowListModel.toFavoriteShowListingEntity(): FavoriteShowListingEntity {
    return FavoriteShowListingEntity(
        id = id,
        name = name,
        type = type,
        runtime = runtime,
        image = image,
        status = status,
        summary = summary,
        premiered = premiered,
        rating = rating
    )
}

fun ShowInfoDto.toShowListing(): ShowListModel {
    return ShowListModel(
        id = id,
        name = name,
        type = type,
        premiered = premiered,
        status = status,
        runtime = runtime ?: 0,
        summary = summary,
        image = image,
        rating = rating
    )
}

fun FavoriteShowListingEntity.toShowListing(): ShowListModel {
    return ShowListModel(
        id = id!!,
        name = name,
        type = type,
        runtime = runtime,
        image = image,
        status = status,
        summary = summary,
        premiered = premiered,
        rating = rating
    )
}
