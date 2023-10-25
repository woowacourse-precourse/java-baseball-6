package utility;

import java.util.Collections;
import java.util.List;

public final class ValidityChecker {
    private ValidityChecker(){}
    public static void validateBaseballNumberSize(final String input)
            throws IllegalArgumentException{
        if(input.length() != 3)
            throw new IllegalArgumentException();
    }
    public static void validateBaseballNumberType(final String input)
            throws IllegalArgumentException{
        char[] guessCharArr = input.toCharArray();
        for(int i = 0; i<input.length(); i++){
            if(!Character.isDigit(guessCharArr[i]))
                throw new IllegalArgumentException();
        }
    }
    public static void isBaseballNumberSequence(final List<Integer> numbers,final int maxSize)
            throws IllegalArgumentException{
        int currentNumber;
        for(int i = 0; i<maxSize; i++){
            currentNumber = numbers.get(i);
            if(Collections.frequency(numbers, currentNumber) > 1)
                throw new IllegalArgumentException();
        }
    }
}
