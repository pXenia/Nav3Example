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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Nav3Example"
include(":app")
include(":tasklist:impl")
include(":tasklist")
include(":core:navigation")
include(":featuretwo:api")
include(":featuretwo:impl")
include(":featuredetail:impl")
include(":featuredetail:navigation")
include(":core:database")
include(":core:models")
include(":tasklist:di")
include(":tasklist:navigation")
