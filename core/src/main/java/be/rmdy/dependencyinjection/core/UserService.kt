package be.rmdy.dependencyinjection.core

interface UserService {
    fun login(username:String, password:String):Boolean
}

