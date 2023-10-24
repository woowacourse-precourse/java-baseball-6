package baseball.model;

import baseball.util.ArraysUtils;
import baseball.util.InputValidator;
import java.util.List;

public class Player {
    public static String playerNumber;
    public static List<Integer> playerNumbers;

    public static void setPlayerNumber(String inputNumber) {
        playerNumber = inputNumber;
        isValidNumber();
        playerNumbers = ArraysUtils.stringToList(inputNumber);
    }

    private static String isValidNumber() {
        return InputValidator.checkPlayerInputValue(playerNumber);
    }
}
