package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final String REGEX = "[1-9]+";

    public boolean isRandomNumbers(String input) {

        Set<Character> charSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            charSet.add(c);
        }

        if (!(charSet.size() == 3) || !(input.length() == 3) || !input.matches(REGEX)) {
            return false;
        }

        return true;
    }
}
