package ps.dotech.flickerimagesearch.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ps.dotech.flickerimagesearch.presentation.di.AppComponent
import ps.dotech.flickerimagesearch.presentation.di.AppModule
import ps.dotech.flickerimagesearch.presentation.di.DaggerAppComponent

@HiltAndroidApp
class FlickerApp : Application(){
    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent(): AppComponent {
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
        return appComponent
    }
}