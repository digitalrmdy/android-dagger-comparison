package be.rmdy.dependencyinjection

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    private lateinit var appComponent: AppComponent
    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder().application(this).build()
    }

    private fun inject() {
        appComponent = buildAppComponent()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}