package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    static String getUserNumber() {
        String userInput = readLine().trim();
        isValidInput(userInput);
        return userInput;
    }

    static boolean getUserRestart() {
        String restart = readLine().trim();
        if (!(restart.equals("1") || restart.equals("2"))) {
            throw new IllegalArgumentException();
        }
        return restart.equals("1");
    }

    private static boolean hasDuplicateCharacter(final String input) {
        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            for (int j = i + 1; j < input.length(); ++j) {
                if (currentChar == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void isValidInput(final String input) {
        if (input.length() != Constants.NUMBER_SIZE || !input.matches("\\d+") || hasDuplicateCharacter(input)) {
            throw new IllegalArgumentException();
        }
    }
}
