package baseball.Controller;

import java.util.HashSet;
import java.util.Set;

public class User_Controller {

    public int[] UserInput(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        checkSame(input);
        return getNum(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSame(String input) throws IllegalArgumentException{
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }

    private int[] getNum(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
