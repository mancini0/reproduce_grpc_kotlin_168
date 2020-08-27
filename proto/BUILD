package(default_visibility = ["//visibility:public"])

load("@rules_proto//proto:defs.bzl", "proto_library")
load("@com_github_grpc_grpc_kotlin//:kt_jvm_grpc.bzl", "kt_jvm_grpc_library")


proto_library(
    name = "hello_proto",
    srcs = ["hello.proto"],
    deps = [],
)


java_proto_library(
    name = "hello_java_proto",
    deps = [":hello_proto"],
)


kt_jvm_grpc_library(
    name = "kt_grpc_hello",
    srcs = [":hello_proto"],
    deps = [
        ":hello_java_proto",
    ],
)
