package baseball;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.controller.BaseBallGameController;
import baseball.controller.FrontController;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Score;
import baseball.service.BaseBallGameService;
import baseball.service.DefaultConsoleService;
import baseball.service.DefaultRandomService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.valid.InputValidator;
import java.util.List;

public class Application {

    private static final int EXIT_NUMBER = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameService baseBallGameService = new BaseBallGameService(
                new RandomNumberGenerator(new DefaultRandomService()));
        InputView inputView = new InputView(new DefaultConsoleService(), new InputValidator());
        OutputView outputView = new OutputView();
        FrontController frontController = new FrontController(inputView, outputView,
                new BaseBallGameController(baseBallGameService));
        Score gameResult;

        frontController.sayGameStart();

        do {
            List<Integer> answerNumbers = frontController.createAnswerNumber();
            gameResult = frontController.startGame(answerNumbers);
        } while (playingGame(gameResult, inputView));
    }

    private static boolean playingGame(Score gameResult, InputView inputView) {
        if (gameResult == THREE_STRIKE) {
            int restartOrExit = inputView.restartOrExit();
            return restartOrExit != EXIT_NUMBER;
        }
        return true;
    }
}
