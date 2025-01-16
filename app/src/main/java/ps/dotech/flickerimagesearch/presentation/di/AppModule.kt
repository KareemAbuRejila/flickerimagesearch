package ps.dotech.flickerimagesearch.presentation.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import ps.dotech.flickerimagesearch.BuildConfig
import ps.dotech.flickerimagesearch.data.remote.apis.FlickrApiService
import ps.dotech.flickerimagesearch.data.remote.repositories.ImagesRepoImpl
import ps.dotech.flickerimagesearch.domain.repositories.ImagesRepo
import ps.dotech.flickerimagesearch.presentation.FlickerApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(OkHttpProfilerInterceptor()).build()
    }

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): FlickrApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(FlickrApiService::class.java)

    @Provides
    @Singleton
    fun provideImagesRepo(api: FlickrApiService): ImagesRepo = ImagesRepoImpl(api = api)

//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
//        Room.databaseBuilder(
//            myApp.baseContext,
//            AppDatabase::class.java,
//            AppDatabase::class.java.simpleName
//        ).fallbackToDestructiveMigration().build()

//    @Provides
//    @Singleton
//    fun provideQuotesDao(database: AppDatabase): CountryDao = database.countryDao()


}