load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test")

kt_jvm_library(
    name = "hello-service",
    srcs = [
        "src/main/kotlin/HelloService.kt",
    ],
    deps = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_coroutines_core",
        "@io_grpc_grpc_java//stub",
        "//proto:kt_grpc_hello",
    ],
)


kt_jvm_test(
    name="hello-service-test",
    srcs = ["src/test/kotlin/HelloServiceTest.kt"],
    test_class = "com.mancini.HelloServiceTest",
    deps=["@maven//:junit_junit",
          ":hello-service",
          "@maven//:com_google_truth_truth",
          "@io_grpc_grpc_java//testing"]
)