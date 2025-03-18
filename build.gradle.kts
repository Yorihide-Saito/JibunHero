// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    // トップレベルの適応しないため apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.spotless) apply false
}

subprojects {
    apply(plugin = rootProject.libs.plugins.spotless.get().pluginId)

    // サブモジュールに spotless の適応を行う
    // https://github.com/diffplug/spotless/tree/main/plugin-gradle#kotlin
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            ktlint()
        }

        kotlinGradle {
            target("*.gradle.kts")
            ktlint()
        }
    }
}