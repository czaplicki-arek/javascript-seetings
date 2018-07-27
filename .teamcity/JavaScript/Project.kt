package JavaScript

import JavaScript.buildTypes.*
import JavaScript.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project
import jetbrains.buildServer.configs.kotlin.v2018_1.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_1.projectFeatures.versionedSettings

object Project : Project({
    uuid = "a1c2a1bc-3859-47f0-a9df-3a8cdb270ea1"
    id("JavaScript")
    parentId("_Root")
    name = "JavaScript"
    description = "My Javascript Project"
    
    vcsRoot(JavaScript_VCSRoot)

    buildType(JavaScript_03DeployToStaging)
    buildType(JavaScript_01FastTest)
    buildType(JavaScript_02Chrome)
    buildType(JavaScript_02IE)
    
    template(JavaScript_Template)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "HttpsGithubComCzaplickiArekJavascriptSeetingsGit"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
