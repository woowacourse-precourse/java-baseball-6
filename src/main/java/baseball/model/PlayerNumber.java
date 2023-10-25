package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String playerNumber) {
        isDigitNumber(playerNumber);
        isStringLengthCorrect(playerNumber);
        isDifferentNumber(playerNumber);
        isContainZero(playerNumber);
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public static void isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요");
        }
    }

    public static void isDifferentNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요");
        }
    }

    public static void isDigitNumber(String word) throws IllegalArgumentException {
        if (!word.matches("\\d+")) {
            throw new IllegalArgumentException("자연수를 입력해주세요");
        }
    }

    public static void isContainZero(String word) throws IllegalArgumentException {
        if (word.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지 숫자중에 선택해주세요");
        }
    }


}
