package be.rmdy.dependencyinjection

import android.content.Context
import be.rmdy.dependencyinjection.core.RestClient
import be.rmdy.dependencyinjection.core.User
import be.rmdy.dependencyinjection.core.UserService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestClientImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : RestClient {
    override fun fetchUsers(): List<User> {
        return emptyList()
    }
}

@Module
@InstallIn(ApplicationComponent::class)
interface AppModule {
    @Binds
    fun restClient(impl:RestClientImpl):RestClient
    @Binds
    fun userService(impl:UserServiceImpl):UserService
}


class UserServiceImpl @Inject constructor(private val restClient: RestClient) : UserService {
    override fun login(username: String, password: String): Boolean {
        return restClient.fetchUsers().any { it.username == username }
    }
}