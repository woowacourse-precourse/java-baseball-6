package baseball.view;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public String inputOtherThreeNumbers() {
        outputView.printInputNumbersMessage();

        String input = readLine();
        InputValidator.validateNumericInput(input);
        return input;
    }

    public String inputGameStatus() {
        outputView.printGameSuccessMessage();
        outputView.printGameActionMessage();

        String input = readLine();
        InputValidator.validateNumericInput(input);
        return input;
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
