package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object JavaScript_03DeployToStaging : BuildType({
    uuid = "d9b2ae98-a35e-4b74-a0f2-1efe6c570b8e"
    name = "03. Deploy To Staging"

    vcs {
        root(JavaScript.vcsRoots.JavaScript_VCSRoot)
    }

    triggers {
        vcs {
            branchFilter = ""
        }
    }

    dependencies {
        snapshot(JavaScript_02Chrome) {
        }
        snapshot(JavaScript_02IE) {
        }
    }
})
