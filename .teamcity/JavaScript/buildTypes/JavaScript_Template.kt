package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script

object JavaScript_Template : Template({
    uuid = "b980f7cf-139d-45dc-9943-e38f52abe16f"
    name = "Template"

    vcs {
        root(JavaScript.vcsRoots.JavaScript_VCSRoot)
    }

    steps {
        script {
            name = "npm install"
            id = "RUNNER_7"
            scriptContent = "npm install"
        }
        script {
            name = "Browser Tests"
            id = "RUNNER_8"
            scriptContent = "npm test -- --single-run --browsers %Browser% --colors false --reporters teamcity"
        }
    }
})
