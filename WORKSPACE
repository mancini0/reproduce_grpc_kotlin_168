load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

rules_jvm_external_tag = "2.10"

rules_jvm_external_sha = "1bbf2e48d07686707dd85357e9a94da775e1dbd7c464272b3664283c9c716d26"


grpc_version = "1.31.0"

kafka_version = "2.6.0"

http_archive(
    name = "rules_jvm_external",
    sha256 = rules_jvm_external_sha,
    strip_prefix = "rules_jvm_external-%s" % rules_jvm_external_tag,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % rules_jvm_external_tag,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

git_repository(
    name = "com_github_grpc_grpc_kotlin",
    branch = "master",
    remote = "https://github.com/grpc/grpc-kotlin.git",
)

load("@com_github_grpc_grpc_kotlin//:repositories.bzl", "IO_GRPC_GRPC_KOTLIN_ARTIFACTS")

maven_install(
    name = "maven",
    artifacts = [
        "junit:junit:4.13",
        "com.google.truth:truth:1.0.1",
        "javax.inject:javax.inject:1",
        "org.slf4j:slf4j-api:1.7.25",
        "ch.qos.logback:logback-classic:1.2.3",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:jar:1.3.8",
        "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:jar:1.3.8",
    ] + IO_GRPC_GRPC_KOTLIN_ARTIFACTS,
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2",
    ],
)


http_archive(
    name = "io_grpc_grpc_java",
    strip_prefix = "grpc-java-%s" % grpc_version,
    url = "https://github.com/grpc/grpc-java/archive/v%s.zip" % grpc_version,
)

http_archive(
    name = "com_google_protobuf",
    strip_prefix = "protobuf-3.12.0",
    urls = ["https://github.com/google/protobuf/archive/v3.12.0.zip"],
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

rules_kotlin_version = "legacy-1.4.0-rc3"

http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" % rules_kotlin_version],
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()


load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_proto",
    sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
    strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
    ],
)
load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")
rules_proto_dependencies()
rules_proto_toolchains()


load("@com_github_grpc_grpc_kotlin//:repositories.bzl", "grpc_kt_repositories")

grpc_kt_repositories()
