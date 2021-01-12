package be.rmdy.dependencyinjection.core

interface RestClient {
    fun fetchUsers(): List<User>
}