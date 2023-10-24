package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void checkPlayerNumber(int input) throws IllegalArgumentException {
        String inputNumber = Integer.toString(input);
        if(inputNumber.length()!=3)throw new IllegalArgumentException();

        Set<Character> numberSet = new HashSet<>();
        for(char c : inputNumber.toCharArray()){
            numberSet.add(c);
        }
        if(numberSet.size()!=3) throw new IllegalArgumentException();

    }

    public static void checkRestartNumber(String input) throws IllegalArgumentException {
        if (!input.equals("1")&& !input.equals("2")) throw new IllegalArgumentException();

    }

}

