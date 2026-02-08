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
include(":core:navigation")
include(":core:database")
include(":core:models")
include(":tasklist:impl")
include(":tasklist:di")
include(":tasklist:navigation")
include(":taskdetails:impl")
include(":taskdetails:di")
include(":taskdetails:navigation")
include(":featuretwo:api")
include(":featuretwo:impl")