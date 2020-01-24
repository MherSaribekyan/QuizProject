package am.egs.quizproject.service;

import am.egs.quizproject.model.Answer;
import am.egs.quizproject.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void saveAnswers(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            answerRepository.save(answers.get(i));
        }
    }

    public List<Answer> getAnswers(long requestId) {
        return answerRepository.getAllById(requestId);
    }

}
