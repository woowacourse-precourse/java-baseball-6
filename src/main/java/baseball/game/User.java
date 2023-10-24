package baseball.game;

import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class User {
    public int[] getGuessNumbers() {
        String userInput = Console.readLine();
        if (!ValidationUtils.isValidGuess(userInput)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int getChoiceToPlayAgain() {
        String userInput = Console.readLine();
        if (!ValidationUtils.isValidChoice(userInput)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userInput);
    }
}
