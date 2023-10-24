package utils;

import java.util.HashSet;
import java.util.Set;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class InputValidator {

    public static void validateUserInput(String userInput) {
        validateInputLength(userInput);
        validateInputRange(userInput);
        validateNoDuplicate(userInput);
    }

    private static void validateInputLength(String userInput) {
        if (userInput.length() != NORMAL_LENGTH) {
            throw new IllegalArgumentException(wrongLengthInput);
        }
    }

    private static void validateInputRange(String userInput) {
        for (int i = 0; i < NORMAL_LENGTH; i++) {
            char c = userInput.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException(wrongRangeInput);
            }
        }
    }

    private static void validateNoDuplicate(String userInput) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < NORMAL_LENGTH; i++) {
            set.add(userInput.charAt(i));
        }
        if (set.size() != NORMAL_LENGTH) {
            throw new IllegalArgumentException(hasDuplicateNumber);
        }
    }

    public static int[] changeToIntArray(String userInput){
        int[] intArray = new int[NORMAL_LENGTH];
        for(int i = 0; i<NORMAL_LENGTH; i++){
            intArray[i] = Integer.parseInt(userInput.substring(i,i+1));
        }
        return intArray;
    }
}

