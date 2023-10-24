package baseball;

import java.util.HashSet;


public class Exception {

    public static void validateOneOrTwo(int userInput){
        if(userInput != 1 && userInput != 2){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public static void validateInput(char[] userInput){
        validateDigits(userInput);
        validateLength(userInput);
        validateDuplicateNumbers(userInput);
    }

    public static void validateDigits(char[] userInput){
        for (char c : userInput) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("프로그램 종료");
            }
        }
    }

    public static void  validateLength(char[] userInput){
        if(userInput.length != 3){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public static void validateDuplicateNumbers(char[] userInput){
        HashSet<Character> inputSet = new HashSet<>();
        for (char c : userInput) {
            inputSet.add(c);
        }

        if(inputSet.size() != userInput.length){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }
}
