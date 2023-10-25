package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class InputValidation {
    public static final int CORRECT_INPUT_SIZE = 3;
    public static final String INPUT_CONTINUE = "1";
    public static final String INPUT_EXIT = "2";

    public static String validateUserInput() {
        String userInput = Console.readLine();

        if (userInput.length() != CORRECT_INPUT_SIZE) {
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
        if (checkDuplicate.size() != CORRECT_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public static boolean validateContinue() {
        String userInput = Console.readLine();
        if (userInput.equals(INPUT_CONTINUE)) {
            return true;
        }
        if (userInput.equals(INPUT_EXIT)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
