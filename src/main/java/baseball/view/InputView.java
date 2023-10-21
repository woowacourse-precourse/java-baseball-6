package baseball.view;

import baseball.util.Err;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<Integer> inputOtherThreeNumbers() {
        outputView.printInputNumbersMessage();
        String input = readLine();
        InputValidator.validateNumericInput(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public boolean inputGameAction() {
        outputView.printGameSuccessMessage();
        outputView.printGameActionMessage();

        String input = readLine();
        InputValidator.validateNumericInput(input);

        if ("1".equals(input)) {
            return true;
        }
        if ("2".equals(input)) {
            return false;
        }
        throw new IllegalArgumentException(Err.ERROR_GAME_ACTION_INPUT_MESSAGE.getMessage());
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
