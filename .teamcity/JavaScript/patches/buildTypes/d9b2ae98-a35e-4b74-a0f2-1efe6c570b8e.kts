package JavaScript.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = 'd9b2ae98-a35e-4b74-a0f2-1efe6c570b8e' (id = 'JavaScript_03DeployToStaging')
accordingly, and delete the patch script.
*/
changeBuildType(uuid("d9b2ae98-a35e-4b74-a0f2-1efe6c570b8e")) {
    dependencies {
        remove(AbsoluteId("JavaScript_02IE")) {
            snapshot {
            }
        }

    }
}
