package baseball.view;

import static baseball.view.GameOutput.showGameContinueInputMessage;
import static baseball.view.GameOutput.showNumberInputMessage;

import baseball.Validator;
import baseball.constant.GameStatus;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class GameInput {
    private final Validator validator;

    public GameInput() {
        this.validator = new Validator();
    }

    public List<Integer> userNumberInput() {
        showNumberInputMessage();
        String inputString = Console.readLine();
        validator.numberInput(inputString);

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean getContinueInput() {
        showGameContinueInputMessage();
        String inputContinue = Console.readLine();
        validator.continueInput(inputContinue);
        return inputContinue.equals(GameStatus.CONTINUE.getStatus());
    }
}
