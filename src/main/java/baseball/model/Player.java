package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int START_INDEX = 0;
    private static final char ZERO_CHAR = '0';

    private List<Integer> playerNumbers;

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(String playerNumberStr) {
        this.playerNumbers = convertNumberToList(playerNumberStr);
    }

    private List<Integer> convertNumberToList(String playerNumberStr) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = START_INDEX; index < playerNumberStr.length(); index++) {
            int number = playerNumberStr.charAt(index) - ZERO_CHAR;
            numbers.add(number);
        }

        return numbers;
    }
}
