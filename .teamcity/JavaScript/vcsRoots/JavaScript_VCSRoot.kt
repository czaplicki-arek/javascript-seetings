package JavaScript.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object JavaScript_VCSRoot : GitVcsRoot({
    uuid = "5b5070dd-421c-4a72-8708-91fcf2d75a41"
    name = "VCSRoot"
    url = "https://github.com/g0t4/teamcity-course-cards"
})
