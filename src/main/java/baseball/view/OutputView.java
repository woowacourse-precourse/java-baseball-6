package baseball.view;

public class OutputView {

    public void printGameStart() {
        System.out.println(GameInstructions.GUIDE_GAME_START.getMessage());
    }

    public void printGameSuccess() {
        System.out.println(GameInstructions.GUIDE_GAME_SUCCESS.getMessage());
    }

    public void printForInputThreeDigitNumbers() {
        System.out.printf(GameInstructions.ASK_INPUT_THREE_DIGIT_NUMBERS.getMessage());
    }

    public void printForInputRestartOrExit() {
        System.out.println(GameInstructions.ASK_RESTART_OR_EXIT.getMessage());
    }
}
