package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.utils.Utils;
import baseball.validator.Validator;
import java.util.List;

public class InputView {
    private static final int LENGTH_THREE = 3;
    private static final int LENGTH_ONE = 1;

    public static List<Integer> inputBaseballNumbers() {
        String inputNumbers = readLine();
        Validator.validateIsNumber(inputNumbers);
        Validator.validateInputLength(inputNumbers, LENGTH_THREE);

        List<Integer> playerNumbers = Utils.parseIntegerList(inputNumbers);
        Validator.validateOverlap(playerNumbers);

        return playerNumbers;
    }

    public static int inputGameStateNumber() {
        String inputNumber = readLine();
        Validator.validateIsNumber(inputNumber);
        Validator.validateInputLength(inputNumber, LENGTH_ONE);

        int gameStateNumber = Integer.parseInt(inputNumber);
        return gameStateNumber;
    }
}
