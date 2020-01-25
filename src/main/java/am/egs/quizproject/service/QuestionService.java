package am.egs.quizproject.service;

import am.egs.quizproject.exception.QuestionNotFoundException;
import am.egs.quizproject.model.Question;
import am.egs.quizproject.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getById(long id) throws QuestionNotFoundException {
        return questionRepository.getById(id);
    }

    public List<Question> getQuestionsForTesting() {
        List<Question> questions = new LinkedList<>();
        long min = 1;
        long max = questionRepository.count();
        long diff = max - min;
        Random random = new Random();
        long i = random.nextInt(((int) diff + 1));
        i += min;
        for (int j = 0; j < 20; j++) {
            questions.add(questionRepository.getById(i));
        }
        return questions;
    }


    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }
}
