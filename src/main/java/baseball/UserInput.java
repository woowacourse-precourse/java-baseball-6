package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

class UserInput {

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


    private static void isValidInput(final String input) {
        if (input.length() != 3 || !input.matches("\\d+") || input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}
