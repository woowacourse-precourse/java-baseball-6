package baseball.core;

import camp.nextstep.edu.missionutils.Console;
import baseball.utils.Validator;

import java.util.List;

public class Player {
    private final Validator validator = new Validator();

    public List<Integer> getPlayerNumber() {
        String input = Console.readLine();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }
}
