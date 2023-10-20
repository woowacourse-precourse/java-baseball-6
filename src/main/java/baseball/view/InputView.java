package baseball.view;

import baseball.domain.Player;
import baseball.util.Sentence;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public Player inputThreeNumbers() {
        outputView.printInputNumbersMessage();
        List<Integer> numbers = Arrays.stream(readLine().split(""))
                .map(Integer::parseInt)
                .toList();
        return Player.of(numbers);
    }

    public boolean inputGameAction() {
        outputView.printGameSuccessMessage();
        outputView.printGameActionMessage();
        String gameActionAnswer = readLine();
        if ("1".equals(gameActionAnswer)) {
            return true;
        }
        if ("2".equals(gameActionAnswer)) {
            return false;
        }
        throw new IllegalArgumentException(Sentence.ERROR_GAME_ACTION_INPUT_MESSAGE.getMessage());
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
