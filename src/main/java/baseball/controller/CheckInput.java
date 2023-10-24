package baseball.controller;

import baseball.model.Settings;
import java.util.Arrays;
import java.util.List;

public class CheckInput {
    public static void InputLengthCheck(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void NotOneToNine(String userInput) {
//        String afterRegexInput = userInput.replaceAll("[^1-9]", "");
//        if (afterRegexInput.length() != 3) {
//            throw new IllegalArgumentException();
//        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(String input) {
        String[] numbers = input.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void IsThereDuplicate(String userInput) {
//        Set<Character> inputSet = new HashSet<>();
//
//        for (char c : userInput.toCharArray()) {
//            inputSet.add(c);
//        }
//        if (inputSet.size() != 3) {
//            throw new IllegalArgumentException();
//        }
        String[] numbers = userInput.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckNumberRules(String userInput) {
        InputLengthCheck(userInput);
        NotOneToNine(userInput);
        IsThereDuplicate(userInput);
        validateRange(userInput);
    }

    public static void StrikesAndBalls(List<Integer> computer, String userInput) {
        for (int i = 0; i < 3; i++) {
            int charUserInput = userInput.charAt(i) - '0';
            if (computer.get(i) == charUserInput) {
                Settings.strike++;
            } else if (computer.contains(charUserInput)) {
                Settings.ball++;
            }
        }
    }


}
