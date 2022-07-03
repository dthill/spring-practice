package pgfsd.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pgfsd.springpractice.dto.FeedbackFormDto;
import pgfsd.springpractice.entities.Feedback;
import pgfsd.springpractice.services.FeedbackService;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<String> postFeedback(@Validated @RequestBody FeedbackFormDto feedbackForm){
        Feedback addedFeedback = feedbackService.addFeedback(feedbackForm);
        return new ResponseEntity<>(
                "The following feedback was saved: " + addedFeedback.toString(),
                HttpStatus.CREATED);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> feedbackValidationException(){
        return new ResponseEntity<>(
                "Feedback form not valid. Provide a feedback and a valid user.",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> feedbackIntegrityException(){
        return new ResponseEntity<>(
                "Feedback form not valid. Given user id not valid.",
                HttpStatus.BAD_REQUEST);
    }
}
