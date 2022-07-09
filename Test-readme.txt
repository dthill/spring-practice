# Login Test
The provided app extends the app to add a simple login form requiring the user id and user password both saved as plain text in the MySql database running in a Docker container. As this is only a prototyp security concern of saving passwords in plain text in the database and other possible security issue were ignored.
The controller dedicated to login is tested. All methods/end-points are tested using mocking of the underlying service calls if needed. The underlying service is also tested separatly with a mocked repository layer. The app as a whole has a smoke test implemented to test if the app is actually loading. All tests are implemented using JUnit and all mocking is done with the help of Mockito.

Github Repository:
 https://github.com/dthill/spring-practice