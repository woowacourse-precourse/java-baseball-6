package baseball.ui;

import static baseball.ui.GameOutput.showGameContinueInputMessage;
import static baseball.ui.GameOutput.showNumberInputMessage;

import baseball.constant.GameStatus;
import baseball.domain.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class GameInput {
    private GameInput() {
    }

    public static List<Integer> userNumberInput() {
        showNumberInputMessage();
        String inputString = Console.readLine();
        Validator.numberInput(inputString);

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean getContinueInput() {
        showGameContinueInputMessage();
        String inputContinue = Console.readLine();
        Validator.continueInput(inputContinue);
        return inputContinue.equals(GameStatus.CONTINUE.getStatus());
    }
}
