import org.gradle.api.JavaVersion

// App level config constants
object AppConfig {
    const val compileSdk = 33
    const val minSdk = 28
    const val targetSdk = 33
    const val applicationId = "com.br.wcabral.kotlin.android.githubcompose"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

    val javaJvmTarget = JavaVersion.VERSION_1_8.toString()
    val javaCompatibility = JavaVersion.VERSION_1_8
}
