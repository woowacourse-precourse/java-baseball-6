package baseball;


import baseball.controller.BaseballController;
import baseball.repository.AnswerRepository;
import baseball.service.AnswerService;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AnswerRepository answerRepository = new AnswerRepository();
        AnswerService answerService = new AnswerService(answerRepository);
        View view = new View();
        BaseballController baseballController = new BaseballController(answerService, view);

        //실행
        baseballController.run();
    }
}
