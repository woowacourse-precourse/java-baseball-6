package baseball.start;


import static baseball.Constants.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlayerNumbers {

    private List<Integer> playerNumbers;

    public PlayerNumbers() {
        playerNumbers = new ArrayList<>();
    }

    public List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
    }

    public void readInputNumbers() {
        String readLine = Console.readLine();

        if (isNotValidLength(readLine)) {
            throw new IllegalArgumentException();
        }
        if (isNotNumber(readLine)) {
            throw new IllegalArgumentException();

        }
        if (isNotDifferentNumber(readLine)) {
            throw new IllegalArgumentException();
        }
        StringToIntegerList(readLine);
    }

    private boolean isNotValidLength(String readLine) {
        return readLine.length() != NUMBER_LENGTH;
    }

    private boolean isNotNumber(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            char letter = readLine.charAt(i);
            if (letter < '1' || letter > '9') {
                return true;
            }
        }
        return false;
    }

    private boolean isNotDifferentNumber(String readLine) {
        HashSet<Character> characterSet = new HashSet<>();
        for (char character : readLine.toCharArray()) {
            if (characterSet.contains(character)) {
                return true;
            }
            characterSet.add(character);
        }
        return false;
    }

    private void StringToIntegerList(String readLine) {
        if (playerNumbers.size() > 0) {
            playerNumbers = new ArrayList<>();
        }
        for (int i = 0; i < readLine.length(); i++) {
            char character = readLine.charAt(i);
            String letter = String.valueOf(character);
            playerNumbers.add(Integer.parseInt(letter));
        }
    }
}
