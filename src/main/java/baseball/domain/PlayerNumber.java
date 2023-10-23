package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNumber {
    private List<Integer> playerNumbers;

    public PlayerNumber(String input) {
        generatePlayerNumbers(input);
    }

    private void generatePlayerNumbers(String input) {
        int first = Character.getNumericValue(input.charAt(0));
        int second = Character.getNumericValue(input.charAt(1));
        int third = Character.getNumericValue(input.charAt(2));
        playerNumbers = new ArrayList<>(Arrays.asList(first, second, third));
    }

    public int getIndexNumber(int index) {
        return playerNumbers.get(index);
    }
}
