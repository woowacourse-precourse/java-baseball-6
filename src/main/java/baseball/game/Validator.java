package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private static final int INPUT_LENGTH = 3;
    private static final String REPLAY = "1";
    private static final String TERMINATE = "2";


    public static List<Integer> validate(String input) {
        if (isThreeLength(input) && isNatural(input)) {
            return isUnique(input).stream()
                    .map(c -> (int) (c - '0'))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }

    public static boolean validateCommand(String input) {
        if (input.equals(REPLAY)) {
            return true;
        } else if (input.equals(TERMINATE)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isThreeLength(String input) {
        return input.length() == INPUT_LENGTH;
    }

    private static boolean isNatural(String input) {
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static List<Character> isUnique(String input) {

        ArrayList<Character> ret = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (ret.contains(c)) {
                throw new IllegalArgumentException();
            }
            ret.add(c);
        }
        return ret;
    }

}
