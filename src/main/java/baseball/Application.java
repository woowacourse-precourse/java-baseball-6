package baseball;

import java.util.List;

public class Application {

    public static final int EXIT_NUMBER = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGenerator(new DefaultRandomService()));
        InputDevice inputDevice = new InputDevice(new DefaultConsoleService(), new InputValidator());
        OutputDevice outputDevice = new OutputDevice();
        String gameResult;

        outputDevice.printGameStart();

        do {
            List<Integer> answerNumbers = baseBallGame.createAnswerNumbers();
            BaseBallGameController controller = new BaseBallGameController(inputDevice, baseBallGame, outputDevice);
            gameResult = controller.competeWith(answerNumbers);
            outputDevice.printGameFinish();
        } while (playingGame(gameResult, inputDevice));
    }

    private static boolean playingGame(String gameResult, InputDevice inputDevice) {
        if (gameResult.equals(Score.THREE_STRIKE.getName())) {
            int restartOrExit = inputDevice.restartOrExit();
            return restartOrExit != EXIT_NUMBER;
        }
        return true;
    }
}
