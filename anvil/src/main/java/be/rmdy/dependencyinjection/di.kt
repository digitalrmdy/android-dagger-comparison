package be.rmdy.dependencyinjection

import android.content.Context
import be.rmdy.dependencyinjection.core.RestClient
import be.rmdy.dependencyinjection.core.User
import be.rmdy.dependencyinjection.core.UserService
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@ApplicationScope
@MergeComponent(
    ApplicationScope::class,
    modules = [AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

}

@Module
@ContributesTo(ApplicationScope::class)
interface AppContextModule {
    @Binds
    fun appContext(app: App): Context
}

@ApplicationScope
@ContributesBinding(ApplicationScope::class)
class RestClientImpl @Inject constructor(private val context:Context):RestClient{
    override fun fetchUsers(): List<User> {
        return emptyList()
    }
}

@ContributesBinding(ApplicationScope::class)
class UserServiceImpl @Inject  constructor(private val restClient: RestClient) :UserService{
    override fun login(username: String, password: String): Boolean {
        return restClient.fetchUsers().any { it.username == username }
    }
}