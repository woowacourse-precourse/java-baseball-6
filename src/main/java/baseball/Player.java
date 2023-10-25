package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private static final char MIN_NUMBER = '1';
    private static final char MAX_NUMBER = '9';
    private static final int LENGTH_OF_NUMBER = 3;

    List<Integer> number = new ArrayList<>();

    public void inputPlayerNumber() {
        String input = readLine();
        setPlayerNumber(input);
    }

    private void setPlayerNumber(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        this.number = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private boolean isValidInput(String input) {
        return isThreeDigit(input)
                && isValidRange(input)
                && isNotDuplicate(input);
    }

    private boolean isThreeDigit(String input) {
        return input.length() == LENGTH_OF_NUMBER;
    }

    private boolean isValidRange(String input) {
        for (char digit : input.toCharArray()) {
            if (digit < MIN_NUMBER || digit > MAX_NUMBER) return false;
        }
        return true;
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> uniqueInput = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueInput.add(digit);
        }
        return LENGTH_OF_NUMBER == uniqueInput.size();
    }
}
