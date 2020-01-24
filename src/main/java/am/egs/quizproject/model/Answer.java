package am.egs.quizproject.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "answere")
@Entity
@Data
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "answere_text")
    private String answerText;
    @Column(name = "is_true")
    private boolean isAnswerTrue;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "question_id")
    private long questionId;
}
