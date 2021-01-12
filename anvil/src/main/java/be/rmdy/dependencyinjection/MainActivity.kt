package be.rmdy.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import be.rmdy.dependencyinjection.core.UserService
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Module
    @ContributesTo(ApplicationScope::class)
    abstract class DI {
        @ContributesAndroidInjector
        abstract fun binding(): MainActivity
    }

    @Inject
    lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val loginResult = userService.login("john.doe", "pass")
        println("loginResult: $loginResult")
    }
}