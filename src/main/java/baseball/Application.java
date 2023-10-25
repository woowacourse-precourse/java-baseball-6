package baseball;


import baseball.controller.BaseballController;
import baseball.repository.AnswerRepository;
import baseball.service.AnswerService;
import baseball.service.ExceptionHandlingService;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AnswerRepository answerRepository = new AnswerRepository();
        AnswerService answerService = new AnswerService(answerRepository);
        View view = new View();
        ExceptionHandlingService exceptionHandlingService = new ExceptionHandlingService();
        BaseballController baseballController = new BaseballController(answerService, view, exceptionHandlingService);

        //실행
        baseballController.run();
    }
}
