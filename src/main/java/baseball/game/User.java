package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class User {
    public static int[] getGuessNumbers() {
        int[] guessNumbers = Arrays.stream(Console.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return guessNumbers;
    }
}
