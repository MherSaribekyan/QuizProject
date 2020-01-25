package am.egs.quizproject.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "answere")
@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column(name = "answere_text")
    private String answerText;
    @Column(name = "is_true")
    private boolean isAnswerTrue;
    @ManyToOne
    private Question question;
}
