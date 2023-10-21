package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class MainController {
    private static final char RESTART_GAME_STRING = '1';
    private static final char END_GAME_STRING = '2';
    BaseballGameController baseballGameController;

    public MainController() {
        baseballGameController = new BaseballGameController();
    }

    public void startProgram() {
        boolean isRunning = true;

        OutputView.printStartProgramMessage();
        do {
            baseballGameController.startGame();

            String restartOrNot = InputController.scanRestartOrNot();
            if (restartOrNot.charAt(0) == END_GAME_STRING) {
                isRunning = false;
            }
        } while (isRunning);
    }

    private static class InputController {
        public static String scanRestartOrNot() {
            InputView.printEnterWhetherRestart();
            String userInput = Console.readLine();
            validateWhetherRestart(userInput);
            return userInput;
        }

        private static void validateWhetherRestart(String userInput) {
            if (userInput.length() != 1) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            } else if (userInput.charAt(0) != RESTART_GAME_STRING && userInput.charAt(0) != END_GAME_STRING) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        }
    }
}
