package baseball.view;

public class OutputView {

    private void printGameStart() {
        System.out.println(GameInstructions.GUIDE_GAME_START.getMessage());
    }

    private void printGameSuccess() {
        System.out.println(GameInstructions.GUIDE_GAME_SUCCESS.getMessage());
    }

    private void printForInputThreeDigitNumbers() {
        System.out.println(GameInstructions.ASK_INPUT_THREE_DIGIT_NUMBERS.getMessage());
    }

    private void printForInputRestartOrExit() {
        System.out.println(GameInstructions.ASK_RESTART_OR_EXIT.getMessage());
    }
}
