package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*

object JavaScript_02Chrome : BuildType({
    templates(JavaScript_Template)
    uuid = "0cec3ec6-9da6-45ca-9c38-4f6041dd8b41"
    name = "02. Chrome"

    params {
        param("Browser", "Chrome")
    }

    dependencies {
        snapshot(JavaScript_01FastTest) {
        }
    }
})
