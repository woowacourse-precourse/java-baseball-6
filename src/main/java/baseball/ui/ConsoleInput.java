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

        Utility.checkIfIsInteger(input);
        Utility.checkIfIsDifferent(input);
        Utility.checkIfIsValidLength(length, input);

        return input;
    }
}
