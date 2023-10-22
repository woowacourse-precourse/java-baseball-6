package baseball;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    private final Validator validator = new Validator();
    public List<Integer> getPlayerNumber() {
        String input = Console.readLine();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }
}
