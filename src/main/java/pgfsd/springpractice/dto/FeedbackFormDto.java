package pgfsd.springpractice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FeedbackFormDto {
    @NotNull
    @Size(min = 1, max = 1000)
    private String feedback;

    @NotNull
    @Min(0)
    private Long userId;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
