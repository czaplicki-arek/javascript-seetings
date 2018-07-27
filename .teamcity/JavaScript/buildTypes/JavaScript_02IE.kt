
package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*

object JavaScript_02IE : BuildType({
    templates(JavaScript_Template)
    uuid = "javascript_02ie"
    name = "02. Internet Explorer"

    params {
        param("Browser", "IE")
    }

    dependencies {
        snapshot(JavaScript_01FastTest) {
        }
    }
})
