package baseball.Model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String playerNumber) {

        isStringLengthCorrect(playerNumber);
        isDigitPlayerNumber(playerNumber);
        isDifferentPlayerNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    public static void isStringLengthCorrect(String word) throws IllegalAccessError {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitWord(word, i);
        }
    }

    public static void isDigitWord(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
        }
    }

    public static void isDifferentPlayerNumber(String word) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }


    public String getPlayerNumber() {

        return playerNumber;
    }

}
