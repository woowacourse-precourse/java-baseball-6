package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    public String getInputAnswer() {
        String input = Console.readLine();
        InputValidator.validateInputAnswer(input);
        return input;
    }

    public Boolean getIsRetry() {
        String input = Console.readLine();
        InputValidator.validateRetryInput(input);
        return input.equals(RETRY_COMMAND);
    }

    public Player() {

    }
}
