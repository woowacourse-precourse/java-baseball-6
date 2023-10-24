package baseball.core;

import baseball.utils.Utils;
import baseball.utils.Validator;
import java.util.List;

public class Player {
    private final Validator validator = new Validator();
    private final Utils utils = new Utils();

    public List<Integer> getPlayerNumber() {
        String input = utils.readInput();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }

    public int getRestartOrExitNumber() {
        String choice = utils.readInput();
        validator.validateRestartOrExitNumber(choice);

        return Integer.parseInt(choice);
    }
}
