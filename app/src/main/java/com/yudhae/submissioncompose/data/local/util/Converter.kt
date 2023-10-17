package com.yudhae.submissioncompose.data.local.util

import androidx.room.TypeConverter
import com.yudhae.submissioncompose.data.remote.dto.Image
import com.yudhae.submissioncompose.data.remote.dto.Rating

class Converter {
    @TypeConverter
    fun fromImageToString(image: Image): String {
        return image.medium
    }

    @TypeConverter
    fun fromStringToImage(medium: String): Image {
        return Image(medium = medium)
    }

    @TypeConverter
    fun fromRatingToDouble(rating: Rating): Double {
        return rating.average
    }

    @TypeConverter
    fun fromDoubleToRating(average: Double): Rating {
        return Rating(average = average)
    }
}
