package com.yudhae.submissioncompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yudhae.submissioncompose.data.remote.dto.Image
import com.yudhae.submissioncompose.data.remote.dto.Rating

@Entity(tableName = "favorite_show_listing_table")
data class FavoriteShowListingEntity(
    val name: String,
    val type: String,
    val runtime: Int,
    val image: Image,
    val premiered: String,
    val status: String,
    val summary: String,
    val rating: Rating,
    @PrimaryKey val id: Int? = null
)
