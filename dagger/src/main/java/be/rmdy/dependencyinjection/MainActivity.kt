package be.rmdy.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import be.rmdy.dependencyinjection.core.UserService
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val loginResult = userService.login("john.doe", "pass")
        println("loginResult: $loginResult")
    }
}