package baseball.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Exception.InputException.notNumericException;
import static baseball.Exception.InputException.lengthException;
import static baseball.Exception.InputException.duplicateException;
import static baseball.Exception.InputException.outOfRangeException;
import static baseball.Exception.InputException.gameDecisionException;

public class Inputdata {
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