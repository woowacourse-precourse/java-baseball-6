package console;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private InputValidator() {
        throw new IllegalArgumentException("Util class");
    }

    private static final String INVALID_INPUT = "유효하지 않은 입력입니다.";
    private static final int VALID_INPUT_LENGTH = 3;
    public static void validateInput(String userInput) {
        validateInputLength(userInput);
        validateIsNumeric(userInput);
        validateIsDuplicatedNumber(userInput);
    }

    private static void validateIsDuplicatedNumber(String userInput) {
        if (isDuplicatedNumber(userInput)){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private static void validateIsNumeric(String userInput) {
        try{
            Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private static void validateInputLength(String userInput) {
        if (userInput.length() != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private static boolean isDuplicatedNumber(String userInput) {
        Set<Character> uniqueChars = new HashSet<>();
        char[] userInputCharArray = userInput.toCharArray();
        for (char c : userInputCharArray) {
            uniqueChars.add(c);
        }
        return uniqueChars.size() != VALID_INPUT_LENGTH;
    }
}
