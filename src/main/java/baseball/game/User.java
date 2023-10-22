package baseball.game;

import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class User {
    public static int[] getGuessNumbers() {
        String userInput = Console.readLine();
        if (!ValidationUtils.isValidInput(userInput)) {
            throw new IllegalArgumentException();
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
