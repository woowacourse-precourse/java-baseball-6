package baseball;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.controller.BaseBallGameController;
import baseball.domain.BaseBallGame;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Score;
import baseball.service.DefaultConsoleService;
import baseball.service.DefaultRandomService;
import baseball.view.InputDevice;
import baseball.view.InputValidator;
import baseball.view.OutputDevice;
import java.util.List;

public class Application {

    private static final int EXIT_NUMBER = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGenerator(new DefaultRandomService()));
        InputDevice inputDevice = new InputDevice(new DefaultConsoleService(), new InputValidator());
        OutputDevice outputDevice = new OutputDevice();
        Score gameResult;

        outputDevice.printGameStart();

        do {
            List<Integer> answerNumbers = baseBallGame.createAnswerNumbers();

            BaseBallGameController controller = new BaseBallGameController(inputDevice, baseBallGame, outputDevice);
            gameResult = controller.competeWith(answerNumbers);

            outputDevice.printGameFinish();
        } while (playingGame(gameResult, inputDevice));
    }

    private static boolean playingGame(Score gameResult, InputDevice inputDevice) {
        if (gameResult == THREE_STRIKE) {
            int restartOrExit = inputDevice.restartOrExit();
            return restartOrExit != EXIT_NUMBER;
        }
        return true;
    }
}
