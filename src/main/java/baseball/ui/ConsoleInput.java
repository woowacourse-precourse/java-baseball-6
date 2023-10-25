package baseball.ui;

import baseball.utils.Utility;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements IInput {

    @Override
    public String scan() {
        return Console.readLine();
    }

    public String scanGameNumber(final int length) {
        String input = scan();
        validateInput(length, input);

        return input;
    }

    private static void validateInput(int length, String input) {
        Utility.checkIfIsPositiveDigitInteger(input);
        Utility.checkIfIsDifferent(input);
        Utility.checkIfIsValidLength(length, input);
    }
}
