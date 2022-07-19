package pgfsd.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pgfsd.springpractice.dto.FeedbackFormDto;
import pgfsd.springpractice.entities.Feedback;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.repositories.FeedbackRepository;

import javax.transaction.Transactional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Transactional
    public Feedback addFeedback(FeedbackFormDto feedbackForm) {
        return feedbackRepository.save(
                new Feedback(feedbackForm.getFeedback(), new User(feedbackForm.getUserId(), ""))
        );
    }
}
