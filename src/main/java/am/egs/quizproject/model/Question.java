package am.egs.quizproject.model;


import lombok.Data;

import javax.persistence.*;

@Table(name = "question")
@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column(name = "question_text")
    private String text;


}
