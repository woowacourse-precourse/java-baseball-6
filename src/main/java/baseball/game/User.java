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
        int[] guessNumbers = Arrays.stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return guessNumbers;
    }
}
