rootProject.name = "moviedatabase"

include(
        ":app-android:base",
        ":app-android:movie",

        ":network:mobileapi",
        ":network:mobileapi-client",
        ":network:model"
)

