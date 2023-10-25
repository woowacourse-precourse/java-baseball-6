package baseball;

import baseball.controller.BaseballController;
import baseball.repository.AnswerRepository;
import baseball.service.AnswerService;
import baseball.service.ValidationService;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        getBaseballController().run();
    }

    private static BaseballController getBaseballController() {
        AnswerRepository answerRepository = new AnswerRepository();
        AnswerService answerService = new AnswerService(answerRepository);
        View view = new View();
        ValidationService validationService = new ValidationService();
        return new BaseballController(answerService, view, validationService);
    }
}
