package baseball.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static baseball.exception.InputException.notNumericException;
import static baseball.exception.InputException.lengthException;
import static baseball.exception.InputException.duplicateException;
import static baseball.exception.InputException.outOfRangeException;
import static baseball.exception.InputException.gameDecisionException;

public class InputView {

    public static List<Integer> inputPlayerNumbers() {
        String input = Console.readLine();

        validateInputNumber(input);

        List<Integer> playerNumbers = new ArrayList<>();
        for (String num : input.split("")) {
            int number = Integer.parseInt(num);
            playerNumbers.add(number);
        }

        return playerNumbers;
    }

    private static void validateInputNumber(String input) {
        notNumericException(input);
        lengthException(input);
        duplicateException(input);
        outOfRangeException(input);
    }

    public static boolean inputRestartDecision() {
        String input = Console.readLine();

        gameDecisionException(input);

        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
