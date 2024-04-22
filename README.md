# Mars Rover

Mars Rovers is an Android App that simulates the movement of a rover on a grid.

## Usage

To run the app, first of all you need to run the rover server.

If you open the project in Android Studio, you can run the server by running the `main()`
in  `Application`. You can find this in the Rover module.

You will need to change the host IP by your local IP in the `Application`class.
```
embeddedServer(Netty, host = "192.168.0.23", port = 8080, module = Application::module)
```
Also in `network_security_config.xml` of the app module.
```
<domain includeSubdomains="true">192.168.0.23</domain>
```
And the `BASE_URL` in the `NetworkService` class.
```
const val BASE_URL = "http://192.168.0.23:8080/"
```

For the run the app, just run the app in an emulator running the app.

## Architecture

The app is follows modularization and is divided in different modules:

The Rover module that contain all the business logic of the navigation of the rover. 
And run the server, that the app is consuming.

The network module that contain the logic of the communication with the server.

The ui module that contain some common ui of the app.

Finally, the app module that is the main module of the app. That contains two views
InstructionsFragment and ResultFragment.
The instructions Fragment contain all the logic to send the information to the server, and the
result show the result of the rover position.

The app follow an MVVM architecture.

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
- Add feature module (move the logic of the result and instructions to another module)
- Add detekt for the code style
- Add code coverage
- Add network security

## Video

You can see a video of the app running 

https://github.com/davidrajalentijo/marsRover/assets/6725999/5287cf0c-9625-4ee4-a0eb-8b05588d31d5

## Author
David Raja

## License

```
Copyright 2024 David Raja

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
