# POST Feedback
This Sprint Boot MVC application allows a user to submit a form with his user id and feedback.
The implementation uses a Spring RestController to handle the request. The form is validated using the Validation API provided by Java EE. Form submission handlers and exceptions are handled with dedicated ExceptionHandler inside the FeedbackController.
The feedback from submitted needs to have a feedback string that is not null, not empty and not longer than 1000 characters, as well as a user id of an existing user.
On the client no validation takes place and the form is submitted as an AJAX request using JavaScript to be able to use the Spring REST controller.

GitHub Repository:
https://github.com/dthill/spring-practice