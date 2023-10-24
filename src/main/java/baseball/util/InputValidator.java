package baseball.util;

import baseball.constant.Game;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    /**
     * 플레이어 입력 값 Validation
     *
     * @param playerInputValue
     * @return
     * @comment 조건 : 1. 입력 값 길이가 3인지 2. 숫자 값으로 이루어진 값인지 3. 중복된 값은 없는지
     */
    public static String checkPlayerInputValue(String playerInputValue) {
        if (isThreeLength(playerInputValue) && isNumberValue(playerInputValue) && isNotDuplicate(playerInputValue)) {
            return playerInputValue;
        }
        throw new IllegalArgumentException();
    }

    /**
     * 재시작 및 종료 flag 값 Validation
     * @param flag
     * @return
     */
    public static boolean checkComputerRetryOrFinishFlag(String flag) {
        var isExists = Arrays.stream(Game.GAME_FLAG_LIST).anyMatch(flag::equals);
        if (isExists) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isThreeLength(String inputValue) {
        return inputValue.length() == Game.STRIKE_COUNT;
    }

    private static boolean isNumberValue(String inputValue) {
        return inputValue.matches(Game.REGEX);
    }

    private static boolean isNotDuplicate(String inputValue) {
        Set<Character> set = new HashSet<>();
        for (char number : inputValue.toCharArray()) {
            set.add(number);
        }
        return set.size() == inputValue.length();
    }
}
