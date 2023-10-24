package baseball.core;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    private final Validator validator = new Validator();

    public List<Integer> getPlayerNumber() {
        String input = readInput();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }

    public int getRestartOrExitNumber() {
        String choice = readInput();
        validator.validateRestartOrExitNumber(choice);

        return Integer.parseInt(choice);
    }

    public String readInput() {
        return Console.readLine();
    }
}
