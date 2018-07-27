package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*

object JavaScript_01FastTest : BuildType({
    templates(JavaScript_Template)
    uuid = "a4aa7ff5-2329-4ac8-95ec-08d86117dd7f"
    name = "01 Fast Test"

    params {
        param("Browser", "PhantomJS")
    }
})
