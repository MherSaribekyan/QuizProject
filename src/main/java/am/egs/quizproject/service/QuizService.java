package am.egs.quizproject.service;

import am.egs.quizproject.model.Question;
import am.egs.quizproject.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public QuizService(QuestionService questionService, AnswerService answerService){
        this.questionService = questionService;
        this.answerService = answerService;
    }


    public List<Quiz> getQuizzesForTesting() {
        List<Quiz> quizzes = null;
        List<Question> questions = questionService.getQuestionsForTesting();
        for (Question question : questions) {
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setAnswers(answerService.getAnswers(question.getId()));
            quizzes.add(quiz);
        }
        return quizzes;
    }
}
