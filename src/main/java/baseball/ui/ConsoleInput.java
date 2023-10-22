package baseball.ui;

import baseball.utils.Utility;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInput implements IInput {

    public String scanGameNumber(final int length) {
        String input = scan();

        Utility.checkIfIsInteger(input);
        Utility.checkIfIsValidLength(length, input);

        return input;
    }

    public String scanCommand(List<String> gameCommand) {
        String input = Console.readLine();

        Utility.checkIfIsValidCommand(gameCommand, input);

        return input;
    }

    @Override
    public String scan() {
        return Console.readLine();
    }
}
