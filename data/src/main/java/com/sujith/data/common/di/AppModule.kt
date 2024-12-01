package com.sujith.data.common.di

import com.sujith.data.BuildConfig.BASE_URL
import com.sujith.data.common.api.BooksApiService
import com.sujith.data.feature_bookDetail.dataSource.RemoteBookDetailDataSource
import com.sujith.data.feature_bookDetail.dataSource.RemoteBookDetailDataSourceImpl
import com.sujith.data.feature_bookDetail.repository.BookDetailRepositoryImpl
import com.sujith.data.feature_bookList.dataSource.RemoteBookListDataSource
import com.sujith.data.feature_bookList.dataSource.RemoteBookListDataSourceImpl
import com.sujith.data.feature_bookList.repository.BookListRepositoryImpl
import com.sujith.domain.feature_bookDetail.repository.BookDetailRepository
import com.sujith.domain.feature_bookList.repository.BookListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideBookListRepository(remoteBookListDataSource: RemoteBookListDataSource): BookListRepository =
        BookListRepositoryImpl(remoteBookListDataSource)

    @Provides
    @Singleton
    fun provideRemoteBookListDataSource(apiService: BooksApiService): RemoteBookListDataSource =
        RemoteBookListDataSourceImpl(apiService)

    @Singleton
    @Provides
    fun provideBookDetailRepository(remoteBookDetailDataSource: RemoteBookDetailDataSource): BookDetailRepository =
        BookDetailRepositoryImpl(remoteBookDetailDataSource)

    @Provides
    @Singleton
    fun provideRemoteBookDetailDataSource(apiService: BooksApiService): RemoteBookDetailDataSource =
        RemoteBookDetailDataSourceImpl(apiService)

    @Provides
    @Singleton
    fun provideBookApiService(retrofit: Retrofit): BooksApiService =
        retrofit.create(BooksApiService::class.java)


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

}