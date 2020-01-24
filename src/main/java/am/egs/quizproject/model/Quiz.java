package am.egs.quizproject.model;

import lombok.Data;

import java.util.List;

@Data
public class Quiz {
    private Question question;
    private List<Answer> answers;
}
