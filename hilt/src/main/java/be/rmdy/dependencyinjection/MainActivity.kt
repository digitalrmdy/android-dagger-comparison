package be.rmdy.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import be.rmdy.dependencyinjection.core.UserService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginResult = userService.login("john.doe", "pass")
        println("loginResult: $loginResult")
    }
}