package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    List<Integer> number = new ArrayList<>();

    public void inputPlayerNumber() {
        String input = readLine();
        setPlayerNumber(input);
    }

    public void setPlayerNumber(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        this.number = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    public boolean isValidInput(String input) {
        return isThreeDigit(input)
                && isValidRange(input)
                && isNotDuplicate(input);
    }

    public boolean isThreeDigit(String input) {
        return input.length() == 3;
    }

    public boolean isValidRange(String input) {
        for (char digit : input.toCharArray()) {
            if (digit < '1' || digit > '9') return false;
        }
        return true;
    }

    public boolean isNotDuplicate(String input) {
        Set<Character> uniqueInput = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueInput.add(digit);
        }
        return input.length() == uniqueInput.size();
    }
}
