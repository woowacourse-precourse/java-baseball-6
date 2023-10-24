package baseball.ioSystem;

import java.util.HashSet;
import java.util.Set;

public class PlayerPoint {
    private String playerPoint;

    public PlayerPoint(String number) {
        isLengthNumber(number);
        isDuplicatePlayerNumber(number);
        isZeroNumber(number);
        isDigitNumber(number);

        this.playerPoint = number;

    }

    public String getPlayerPoint() {
        return playerPoint;
    }

    public static void isDuplicatePlayerNumber(String word) {
        Set<Character> set = new HashSet<>();
        for (char i: word.toCharArray()) {
            set.add(i);
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복되지 않은 숫자만 입력가능합니다)");
        }
    }

    public static void isDigitNumber(String word) {
        for (char i : word.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(숫자만 입력가능합니다)");
            }
        }
    }

    public static void isZeroNumber(String word) {
        if (word.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(1이상의 수만 입력 가능합니다)");
        }
    }

    public static void isNotValue(String word) {
        if (!word.equals("1") && !word.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(1과 2만 입력가능합니다)");
        }
    }

    public static void isLengthNumber(String word) {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리수만 입력 가능합니다)");
        }
    }
}
