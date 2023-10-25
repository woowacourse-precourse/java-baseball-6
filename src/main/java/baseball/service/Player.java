package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private final String GAME_INPUT_REGEX = "[1-9]+";
    private final String GAME_INIT_REGEX = "[1-2]+";

    public List<Integer> enterNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine();
        System.out.println(input);

        if (!isRandomNumbers(input)) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public Integer enterMenuNumber() {
        String input = Console.readLine();
        System.out.println(input);

        if (!isNumber(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public boolean isRandomNumbers(String input) {

        Set<Character> charSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            charSet.add(c);
        }

        if (!(charSet.size() == 3) || !(input.length() == 3) || !input.matches(GAME_INPUT_REGEX)) {
            return false;
        }

        return true;
    }

    public boolean isNumber(String input) {

        if (!(input.length() == 1) || !input.matches(GAME_INIT_REGEX)) {
            return false;
        }

        return true;
    }
}
