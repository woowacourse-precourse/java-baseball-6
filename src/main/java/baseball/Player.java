package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
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
        return input.length() == 3;
    }

    private boolean isValidRange(String input) {
        for (char digit : input.toCharArray()) {
            if (digit < '1' || digit > '9') return false;
        }
        return true;
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> uniqueInput = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueInput.add(digit);
        }
        return input.length() == uniqueInput.size();
    }
}
