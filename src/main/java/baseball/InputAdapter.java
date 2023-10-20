package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputAdapter {
    private final Validator validator;

    public InputAdapter(Validator validator) {
        this.validator = validator;
    }

    /**
     * Read a series of 3 numbers of user input in the game loop.
     * If the input doesn't pass the check of the validator, then IllegalArgumentException is thrown.
     * @return the user input intact.
     */
    public String readNumber() {
        String line = Console.readLine();
        this.validator.validate(line);
        return line;
    }

    /**
     * This reads the user response of the query which asks whether the user
     * is going to repeat the game or not, after a game ended.
     * If the user accepts to repeat one more game, this method returns true, otherwise,
     * returns false.
     * If the user enters any string other than "1" or "2", it throws IllegalArgumentException.
     * @return true if the user enters 1, false if the user enters 2.
     */
    public boolean readControlFlow() {
        String line = Console.readLine();
        if (line.equals("1")) {
            return true;
        } else if (line.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }
}
