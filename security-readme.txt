# Spring security
Following the previous login implementation. Spring Security was used in this project to improve the security of the application and facilitate the future maintenance of the application.
The application now follows most security standards that Spring security provides except for password encoding. Here plain text passwords are used as there is no feature yet to register a new user. Once this feature is implemented BCryptPasswordEncoder should be used.
The standard Spring security login page has been replaced by a custom page which in future iterations can be replaced by a more dynamic frontend view (such as Angular).
All the pages except for the home page and the login page require authentication to be accessed.
On successfull login the user is redirected to the home page and on successful logout he is redirected to the login page showing a message informing him of the success of his logout.

GitHub Repository:
https://github.com/dthill/spring-practice