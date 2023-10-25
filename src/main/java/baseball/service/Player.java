package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final String GAME_INPUT_REGEX = "[1-9]+";
    private final String GAME_INIT_REGEX = "[1-2]+";


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
