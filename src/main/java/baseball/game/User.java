package baseball.game;

import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class User {
    public static int[] getGuessNumbers() throws IllegalAccessException {
        String userInput = Console.readLine();
        if (!ValidationUtils.isValidInput(userInput)) {
            throw new IllegalAccessException();
        }
        return Arrays.stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int getChoiceToPlayAgain() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
