package baseball.controller;

import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class MainController {
    private static final String RESTART_GAME = "1";
    BaseballGameController baseballGameController;

    public MainController() {
        baseballGameController = new BaseballGameController();
    }

    public void startProgram() {
        OutputView.printStartProgramMessage();
        do {
            baseballGameController.startGame();
        } while (InputController.scanRestartOrNot().equals(RESTART_GAME));
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
