package baseball;

import java.util.HashSet;


public class Exception {

    public static void checkOneOrTwo(int userInput){
        if(userInput != 1 && userInput != 2){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public static void checkUserInput(char[] userInput){
        checkNumbers(userInput);
        checkDigits(userInput);
        checkDuplicateNumbers(userInput);
    }

    public static void checkNumbers(char[] userInput){
        for (char c : userInput) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("프로그램 종료");
            }
        }
    }

    public static void  checkDigits(char[] userInput){
        if(userInput.length != 3){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public static void checkDuplicateNumbers(char[] userInput){
        HashSet<Character> inputSet = new HashSet<>();
        for (char c : userInput) {
            inputSet.add(c);
        }

        if(inputSet.size() != userInput.length){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }
}
