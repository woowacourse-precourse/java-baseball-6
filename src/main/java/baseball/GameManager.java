package baseball;

import java.util.HashSet;
import java.util.Set;

public class GameManager {
    private static final int FIXED_PLAYER_NUMBERS_LENGTH = 3;
    private static final char MIN_INPUT_VALUE = '1';
    private static final char MAX_INPUT_VALUE = '9';

    public static void validPlayerNumbers(String playerNumbers) {
        if (playerNumbers.length() != FIXED_PLAYER_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("입력은 " + FIXED_PLAYER_NUMBERS_LENGTH + "자리 숫자이어야 합니다.");
        }

        char[] charNumbers = playerNumbers.toCharArray();
        Set<Character> uniqueCharNumbers = new HashSet<>();
        for (char charNumber : charNumbers) {
            if (charNumber < MIN_INPUT_VALUE || charNumber > MAX_INPUT_VALUE) {
                throw new IllegalArgumentException("입력의 각 자리 숫자는 " + MIN_INPUT_VALUE + "에서 " + MAX_INPUT_VALUE + " 사이의 정수이어야 합니다.");
            }
            if (uniqueCharNumbers.contains(charNumber)) {
                throw new IllegalArgumentException("입력의 각 자리 숫자는 서로 다른 숫자이어야 합니다.");
            }
            uniqueCharNumbers.add(charNumber);
        }
    }
}
