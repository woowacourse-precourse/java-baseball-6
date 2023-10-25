package baseball;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String playerNumber) {

        isInteger(playerNumber);
        isInRange(playerNumber);
        isLengthCorrect(playerNumber);
        isDifferentNumbers(playerNumber);

        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public static void isInteger(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 1-9 사이의 수를 입력하세요.");
        }
    }

    public static void isInRange(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            int digitInt = Character.getNumericValue(digit);
            if (digitInt < 1 || digitInt > 9) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 1-9 사이의 수를 입력하세요. (2)");
            }
        }
    }

    public static void isLengthCorrect(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리수를 입력하세요.");
        }
    }

    public static void isDifferentNumbers(String input) throws IllegalArgumentException {
        Set<Character> digitSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            digitSet.add(input.charAt(i));
        }
        if (digitSet.size() != input.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 서로 다른 수를 입력하세요.");
        }
    }


}
