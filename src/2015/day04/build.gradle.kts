plugins {
    `aoc-project-conventions`
}

application {
    mainClass.set("ca.terrylockett.aoc2015.day04.Day04RunnerKt")
}

dependencies {
    implementation(libs.commonsCodec)
}
