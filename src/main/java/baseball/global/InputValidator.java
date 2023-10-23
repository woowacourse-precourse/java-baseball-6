package baseball.global;

import java.util.List;
import java.util.ArrayList;

import baseball.Game;
import baseball.global.util.NumberUtil;

public class InputValidator {

    public static String inGameInput(String input) {
        // 길이 3이 아닌 경우 예외 처리
        if (input.length() != Game.INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

        // 숫자로 변환 불가능한 경우 예외 처리
        NumberUtil.parseIntOrThrowException(input);

        List<Character> array = new ArrayList<>();
        for (int i = 0; i < Game.INPUT_LENGTH; ++i) {
            Character number = input.charAt(i);
            // 숫자가 중복되는 경우 예외 처리
            if (array.contains(number)) {
                throw new IllegalArgumentException();
            }
            // 1이상 9이하의 숫자가 아닌 경우 예외 처리
            if (number - '0' < Game.MIN_NUMBER || number - '0' > Game.MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
            array.add(input.charAt(i));
        }

        return input;
    }

    public static Integer terminateInput(String input) {
        // 숫자로 변환 불가능한 경우 예외 처리
        Integer code = NumberUtil.parseIntOrThrowException(input);
        // 1 또는 2가 아닌 경우 예외 처리
        if (code != Game.GAME_AGAIN_CODE && code != Game.GAME_TERMINATE_CODE) throw new IllegalArgumentException();

        return code;
    }
}
