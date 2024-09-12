pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeRoot(name: String, path: String) {
    include(":$name")
    project(":$name").projectDir = File(path)
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

rootProject.name = "response"

listOf("kommander", "kase", "lexi").forEach {
    includeBuild("../$it")
}

// submodules
includeSubs("response", ".", "core")
includeSubs("response-ktor", "ktor", "client", "server")