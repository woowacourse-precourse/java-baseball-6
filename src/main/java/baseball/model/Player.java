package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String playerNumber;

    public String getPlayerNumber() {
        return playerNumber;
    }

    public Player(String playerNumber) {
        differentToPlayerNumber(playerNumber);
        isDigitNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    // player는 computer와 모든 값이 달라야함
    public static void differentToPlayerNumber(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 수");
        }

        //중복인지 확인
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if (set.size() != str.length()) {
            throw new IllegalArgumentException("숫자 중복함");
        }
    }

    public static void isDigitNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            isDigit(str, i);
        }
    }

    public static void isDigit(String str, int i) {
        if (!Character.isDigit(str.charAt(i))) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }



}

