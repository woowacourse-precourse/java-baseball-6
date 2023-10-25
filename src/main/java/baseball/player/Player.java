package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.player.utils.PlayerInputUtils.UTILS;
import static baseball.player.validator.PlayerInputValidator.VALIDATOR;

public class Player {
    public List<Integer> getNumbers() {
        String input = Console.readLine();
        VALIDATOR.validateInput(input);
        return UTILS.convertInputToList(input);
    }

    public boolean checkRestartOrQuit() {
        String input = Console.readLine();
        return input.equals("2");
    }
}
