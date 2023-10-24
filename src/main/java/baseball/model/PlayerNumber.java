package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumber {
    private List<Integer> playerNumberList;

    public PlayerNumber(String input) {
        isStringLengthError(input);
        isDigitPlayerNumber(input);
        isDifferntPlayerNumber(input);

        setPlayerNumberList(input);
    }

    public void setPlayerNumberList(String word) {
        List<Integer> NumberList = new ArrayList<>();
        for (String s : word.split("")) {
            NumberList.add(Integer.parseInt(s));
        }
        this.playerNumberList = NumberList;
    }

    public List<Integer> getPlayerNumberList() {
        return playerNumberList;
    }

    public static void isStringLengthError(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInWord(word, i);
        }
    }

    public static void isDifferntPlayerNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void isDigitCharInWord(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit((word.charAt(index)))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
