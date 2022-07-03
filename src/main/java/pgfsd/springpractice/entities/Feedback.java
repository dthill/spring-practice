package pgfsd.springpractice.entities;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 1000)
    @Lob
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Feedback() {
    }

    public Feedback(String feedback, User user) {
        this.feedback = feedback;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return getFeedback() + " User: "+ getUser().getId();
    }
}