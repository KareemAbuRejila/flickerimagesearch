package ps.dotech.flickerimagesearch.presentation.di


import dagger.Component
import ps.dotech.flickerimagesearch.presentation.FlickerApp
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: FlickerApp)
}
