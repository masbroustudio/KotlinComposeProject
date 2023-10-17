package com.yudhae.submissioncompose.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.yudhae.submissioncompose.data.local.dao.FavoriteShowDao
import com.yudhae.submissioncompose.data.local.dao.TvShowDao
import com.yudhae.submissioncompose.data.local.datasource.LocalDataSource
import com.yudhae.submissioncompose.data.local.datasource.LocalDataSourceImpl
import com.yudhae.submissioncompose.data.local.db.TvShowDatabase
import com.yudhae.submissioncompose.data.remote.apiservice.TvShowApi
import com.yudhae.submissioncompose.data.remote.datasource.RemoteDataSource
import com.yudhae.submissioncompose.data.remote.datasource.RemoteDataSourceImpl
import com.yudhae.submissioncompose.data.repository.ShowRepositoryImpl
import com.yudhae.submissioncompose.domain.repository.ShowRepository
import com.yudhae.submissioncompose.domain.use_case.FavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(TvShowApi.BASE_URL)
        .build()

    @Provides
    fun providesShowsApi(retrofit: Retrofit): TvShowApi = retrofit.create(TvShowApi::class.java)

    @Provides
    fun providesRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): ShowRepository {
        return ShowRepositoryImpl(localDataSource, remoteDataSource)
    }

    @Provides
    fun provideFavoriteUseCase(repository: ShowRepository): FavoriteUseCase {
        return FavoriteUseCase(repository)
    }

    @Provides
    fun providesDatabase(app: Application): TvShowDatabase {
        return Room.databaseBuilder(
            app,
            TvShowDatabase::class.java,
            "showdb.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideShowDao(database: TvShowDatabase) = database.showDao()

    @Provides
    fun provideFavoriteShowDao(database: TvShowDatabase) = database.favoriteShowDao()

    @Provides
    fun getRemoteDS(showApi: TvShowApi): RemoteDataSource {
        return RemoteDataSourceImpl(showApi)
    }

    @Provides
    fun getLocalDS(
        showDao: TvShowDao,
        favoriteDao: FavoriteShowDao
    ): LocalDataSource {
        return LocalDataSourceImpl(showDao, favoriteDao)
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.Main
}