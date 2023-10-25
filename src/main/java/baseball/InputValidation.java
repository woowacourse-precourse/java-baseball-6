package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class InputValidation {
    public static String validateUserInput() {
        String userInput = Console.readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] userInputArray = userInput.toCharArray();
        HashSet<Character> checkDuplicate = new HashSet<>();
        for (char ch : userInputArray) {
            if (ch > '9' || ch < '1') {
                throw new IllegalArgumentException();
            }
            checkDuplicate.add(ch);
        }
        if (checkDuplicate.size() != 3) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public static boolean validateContinue() {
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
