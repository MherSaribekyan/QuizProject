package am.egs.quizproject.endpoint;

import am.egs.quizproject.exception.QuestionNotFoundException;
import am.egs.quizproject.model.Question;
import am.egs.quizproject.model.Quiz;
import am.egs.quizproject.service.AnswerService;
import am.egs.quizproject.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminEndpoint {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public AdminEndpoint(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PutMapping("/quiz")
    public ResponseEntity quiz(@RequestBody Quiz quiz) {
        try {
            questionService.saveQuestion(quiz.getQuestion());
            answerService.saveAnswers(quiz.getAnswers());
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/quiz")
    public List<Quiz> quizList(){
        List<Quiz> quizList = null;
        List<Question> allQuestions = questionService.getAllQuestions();
        for (Question question : allQuestions) {
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setAnswers(answerService.getAnswers(question.getId()));
            quizList.add(quiz);
        }
        return quizList;
    }

    @DeleteMapping("quiz/{id}")
    public ResponseEntity deleteQuiz(@PathVariable ("id") long id){
        try {
            questionService.findById(id);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        questionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
