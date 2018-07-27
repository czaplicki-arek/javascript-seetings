import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.1"

project {

    vcsRoot(VCSRoot)

    buildType(03DeployToStaging)
    buildType(01FastTest)
    buildType(02Chrome)

    template(Template_1)
}

object 01FastTest : BuildType({
    templates(Template_1)
    name = "01 Fast Test"

    params {
        param("Browser", "PhantomJS")
    }
})

object 02Chrome : BuildType({
    templates(Template_1)
    name = "02. Chrome"

    params {
        param("Browser", "Chrome")
    }

    dependencies {
        snapshot(01FastTest) {
        }
    }
})

object 03DeployToStaging : BuildType({
    name = "03. Deploy To Staging"

    vcs {
        root(VCSRoot)
    }

    dependencies {
        snapshot(02Chrome) {
        }
    }
})

object Template_1 : Template({
    id("Template")
    name = "Template"

    vcs {
        root(VCSRoot)
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

object VCSRoot : GitVcsRoot({
    name = "VCSRoot"
    url = "https://github.com/g0t4/teamcity-course-cards"
})
