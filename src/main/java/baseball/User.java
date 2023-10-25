package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    User() {}

    public String getInput() {
        String input = Console.readLine();

        checkInputException(input);

        return input;
    }

    public boolean checkNextGame() {
        String result = Console.readLine();

        if (result.equals("2"))
            return true;
        else if (result.equals("1"))
            return false;
        else
            throw new IllegalArgumentException();
    }

    private void checkInputException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if ((input.charAt(0) == input.charAt(2)) || (input.charAt(0) == input.charAt(1)) || (input.charAt(1) == input.charAt(2))) {
            throw new IllegalArgumentException();
        } else {
            char tmp;
            for (int i = 0; i < 3; i++) {
                tmp = input.charAt(i);

                if (!('0' <= tmp && tmp <= '9')) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
