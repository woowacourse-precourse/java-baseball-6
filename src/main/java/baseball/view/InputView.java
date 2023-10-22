package baseball.view;

import baseball.domain.GameStatus;
import baseball.util.InputValidator;
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

    public GameStatus inputGameStatus() {
        outputView.printGameSuccessMessage();
        outputView.printGameActionMessage();

        String input = readLine();
        InputValidator.validateNumericInput(input);
        return GameStatus.of(input);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
