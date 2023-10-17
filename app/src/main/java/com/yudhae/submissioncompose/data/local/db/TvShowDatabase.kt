package com.yudhae.submissioncompose.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yudhae.submissioncompose.data.local.dao.FavoriteShowDao
import com.yudhae.submissioncompose.data.local.dao.TvShowDao
import com.yudhae.submissioncompose.data.local.entity.FavoriteShowListingEntity
import com.yudhae.submissioncompose.data.local.entity.ShowListingEntity
import com.yudhae.submissioncompose.data.local.util.Converter

@Database(
    entities = [ShowListingEntity::class, FavoriteShowListingEntity::class],
    version = 12,
    exportSchema = false
)

@TypeConverters(Converter::class)
abstract class TvShowDatabase : RoomDatabase() {
    abstract fun showDao(): TvShowDao
    abstract fun favoriteShowDao(): FavoriteShowDao
}