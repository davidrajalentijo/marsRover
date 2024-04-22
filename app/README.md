# Mars Rover

Mars Rovers is an Android App that simulates the movement of a rover on a grid.

## Usage

To run the app, first of all you need to run the rover server.

If you open the project in Android Studio, you can run the server by running the `main()`
in  `Application`.
You will need to change the host IP by your local IP, also in `network_security_config.xml` of the
app module.

For the run the app, just run the app in an emulator running the app.

## Architecture

The app is divided in different modules:

The Rover module that contain all the logic of the navigation of the rover. And run the server, that
the app is consuming.

The network module that contain the logic of the communication with the server.

The ui module that contain the UI of the app.

Finally, the app module that is the main module of the app. That contains two views
InstructionsFragment and ResultFragment.
The instructions Fragment contain all the logic to send the information to the server, and the
result show the result of the rover position.

## Main Libraries

The app uses the following libraries:

- Ktor: For the communication with the server.
- Fragment: For the UI.
- Koin: For the dependency injection.
- Espresso: For the UI tests.
- Junit: For the unit tests.
- Mockk: For the mocking in the tests.
- Coroutines: For the async operations.

## Next steps

The app has some improvements that can be done:

- Improve UI (Views, animations, navigation, validations, etc)
- Improve the error handling
- Add network security
- Add detekt for the code style

## Video

You can see a video of the app running [here](https://drive.google.com/file/d/1Z9

## Author
David Raja
