package baseball.controller;

import baseball.validator.Validator;
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
            InputView.printEnterRestartOrNot();
            String userInput = Console.readLine();
            validateRestartOrNot(userInput);
            return userInput;
        }

        private static void validateRestartOrNot(String userInput) {
            Validator.validateNull(userInput);
            Validator.validateSize(userInput, 1);
            Validator.validateInRange(userInput.charAt(0) - '0', 1, 2);
        }
    }
}
