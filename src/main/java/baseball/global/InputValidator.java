package baseball.global;

import java.util.List;
import java.util.ArrayList;

import baseball.Game;
import baseball.global.util.NumberUtil;

public class InputValidator {

    public static String inGameInput(String input) {
        if (input.length() != Game.INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

        NumberUtil.parseIntOrThrowException(input);

        List<Character> array = new ArrayList<>();
        for (int i = 0; i < Game.INPUT_LENGTH; ++i) {
            Character number = input.charAt(i);
            if (array.contains(number)) {
                throw new IllegalArgumentException();
            }
            if (number - '0' < Game.MIN_NUMBER || number - '0' > Game.MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
            array.add(input.charAt(i));
        }

        return input;
    }

    public static Integer terminateInput(String input) {
        Integer code = NumberUtil.parseIntOrThrowException(input);
        if (code != Game.GAME_AGAIN_CODE && code != Game.GAME_TERMINATE_CODE) throw new IllegalArgumentException();

        return code;
    }
}
