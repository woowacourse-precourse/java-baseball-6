package baseball.view;

import baseball.util.Err;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int INPUT_SIZE = 3;
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    private static String validateInput(String input, int inputSize) {
        InputValidator.validateInputLength(input, inputSize);
        InputValidator.validateInputScope(input, inputSize);
        InputValidator.validateInputDuplicated(input);
        return input;
    }

    public static String inputByTest(String testInput) {
        return validateInput(testInput, INPUT_SIZE);
    }

    public static String inputGameActionByTest(String input) {
        return input;
    }

    public List<Integer> inputOtherThreeNumbers() {
        outputView.printInputNumbersMessage();
        String validatedInput = validateInput(readLine(), INPUT_SIZE);

        return Arrays.stream(validatedInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public boolean inputGameAction() {
        outputView.printGameSuccessMessage();
        outputView.printGameActionMessage();
        String gameActionAnswer = inputGameActionByTest(readLine());
        if ("1".equals(gameActionAnswer)) {
            return true;
        }
        if ("2".equals(gameActionAnswer)) {
            return false;
        }
        throw new IllegalArgumentException(Err.ERROR_GAME_ACTION_INPUT_MESSAGE.getMessage());
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
