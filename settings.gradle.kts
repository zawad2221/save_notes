pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SaveNotesRoot"
include(":app")
include(":core:ui:design-system")
include(":core:ui:dimens")
include(":core:ui:fonts")
include(":core:ui:commonui")
include(":core:constants")
include(":core:common")
include(":core:database")
include(":core:datastore")
include(":core:model")
include(":core:datastore-proto")
include(":core:data")
include(":feature:notes")
include(":feature:search")
include(":base")
