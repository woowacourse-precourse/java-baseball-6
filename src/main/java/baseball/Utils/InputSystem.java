package baseball.Utils;

import camp.nextstep.edu.missionutils.Console;

public class InputSystem {
    public static int[] inputNumbers() {
        var number = Console.readLine();

        var numbers = Parser.parseToInt(number, 3);

        return numbers;
    }

    public static Boolean inputRetryAnswer() throws IllegalArgumentException {
        var answer = Integer.parseInt(Console.readLine());

        if (answer < 1 || answer > 2) {
            throw new IllegalArgumentException();
        }

        if (answer == 1) {
            return true;
        } else {
            return false;
        }
    }
}
