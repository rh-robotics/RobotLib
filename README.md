 # RobotLib
 This is a standalone library meant to help with composing the features and functionality of a robot for FTC competitions. This library has a dependency on the FTC starter for compiling code but does not include that in the distribution.

 ## Library Structure

 ### Robot
 The Robot is the primary object and is designed to encapsulate all functionality whether running in teleop or autonomous modes. A Robot, for purposes of competition is meant to be constructed with a DriveTrain but to make functional development simpler this is not a requirement.

 ### OperatorControl
 This is an object meant to encapsulate controllers during teleop mode. It currently only wraps Gamepad1 and Gamepad2 but can be adapted for other types of supported controllers. The OperatorControl takes the new versions of the Gamepad objects from the FTC control loop and understands how to track current and previous as well as converting joystic positions into Vector2d helper objects.

 ### Subsystem
 This defines any independent feature/functionality of the Robot. For teleop, the Subsystems register with the Robot and are given the new state of the OperatorControl in order to determine whether or not action on that specific system needs to be taken.

 ### DriveTrain
 The DriveTrain is a very specific type of Subsystem and also takes action during teleop based on the event loop using the same triggering mechanism as all other Subsystems. The DriveTrain is the interface all drive system should implement - such as TankDriveTrain, SwerveDriveTrain and StrafeDriveTrain

 ### Helpers
 This library also provides helpers such as Vector2d and Angle classes for doing some of the hard math and conversions (like radians to degrees and magnitude calculations)

 ## Dependencies
 This library should follow the version of the FTC libraries for the current season of FTC - for example, the initial version was 11.1.0 which can be found in the `build.dependencies.gradle` file.

 ## Build and Deploy
 You can explicity build locally in order to verify code correctness - if your IDE is not doing this as you go, you can run `./gradlew build` from the root directory. Make sure you use the wrapper (gradlew) to make sure the correct minimum version of gradle is being loaded and executed.

 Once you have pushed local changes to the github [RobotLib Repository](https://github.com/rh-robotics/RobotLib) and have merged it to main you can build a new version of the library artifact (specific to Android) by tagging with a new semantic version number.

 If you are on the `main` branch locally you can run `git tag v1.0.x && git push origin v1.0.x` where `x` is the next iteration of the version number. Tagging with a version number `v*` triggers a GitHub action that will generate a new artifact.

 ### Using the library artifact
 Once you have a new repository cloned from the appropriate version of the FTC starter you will need to add the *RobotLib* as a dependency by making sure you have the appropriate repository and dependancy defined

 ```
 repositories {
    maven {
        url = uri("https://maven.pkg.github.com/rh_robotics/RobotLib")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}
dependencies {
    implementation 'org.rowlandhall:robotlib:1.0.0'
}
```
