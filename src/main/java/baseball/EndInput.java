package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndInput {
    private static final String RESUME = "1";
    private static final String END = "2";
    private static final String END_INPUT_RULE = RESUME + "|" + END;
    private final String input;

    public EndInput() {
        String input = Console.readLine();
        validateEndInput(input);
        this.input = input;
    }

    private void validateEndInput(String input) {
        if (!input.matches(END_INPUT_RULE)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPressResume() {
        return RESUME.equals(input);
    }
}
