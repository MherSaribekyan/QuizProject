package am.egs.quizproject.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "question")
@Entity
@Data
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "question_text")
    private String text;


}
