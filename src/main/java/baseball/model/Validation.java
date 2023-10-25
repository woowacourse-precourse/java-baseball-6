package baseball.model;

import java.util.HashSet;

import static java.lang.Integer.parseInt;

public class Validation {
    public static int isValidateNumber(String userInput){
        int inputNumber;

        try {
            inputNumber = parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수가 아닌 문자열입니다.");
        }

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        if (userInput.contains("0")) {
            throw new IllegalArgumentException("0이 포함되어 있으면 안됩니다.");
        }

        if (isDuplicate(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있으면 안됩니다.");
        }

        return inputNumber;
    }

    public static boolean isDuplicate(String userInput) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            charSet.add(userInput.charAt(i));
        }
        return charSet.size() != userInput.length();
    }

    public static int getOptionNumber(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("숫자 1 또는 2만 입력할 수 있습니다.");
        }
        return parseInt(userInput);
    }
}
