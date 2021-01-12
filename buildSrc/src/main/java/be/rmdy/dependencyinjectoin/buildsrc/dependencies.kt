@file:Suppress("unused", "SpellCheckingInspection")

package be.rmdy.dependencyinjectoin.buildsrc

object Deps {
    object Dagger {
        private const val version = "2.30.1"
        const val dagger = "com.google.dagger:dagger:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }


    object Anvil {
        private const val version = "2.0.11"
        const val plugin = "com.squareup.anvil:gradle-plugin:$version"
        const val common = "com.squareup.anvil:annotations:$version"
    }

    object Hilt {
        private const val version = "2.28-alpha"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }
}
