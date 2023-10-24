package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {

    private String playerNumber;

    public String getPlayerNumber() {
        return playerNumber;
    }

    public PlayerNumber(String playerNumber) {

        isStringLengthCorrect(playerNumber);
        isDigitPlayerNumber(playerNumber);
        isDifferentPlayerNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    /**
     * @param word 중복된 숫자가 있는지 검사
     */
    private void isDifferentPlayerNumber(String word) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); ++i) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }

    /**
     * 모두 숫자인지 검사
     */
    private void isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); ++i) {
            isDigitCharInString(word, i);
        }

    }

    private void isDigitCharInString(String word, int i) {
        if (!Character.isDigit(word.charAt(i))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
        }
    }

    private void isStringLengthCorrect(String word) {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }
}
