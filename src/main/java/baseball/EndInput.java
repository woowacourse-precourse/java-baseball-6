package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndInput {
    private final String input;

    public EndInput() {
        String input = Console.readLine();
        validateEndInput(input);
        this.input = input;
    }

    private void validateEndInput(String input) {
        if (!input.matches("[12]")) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPressResume() {
        return "1".equals(input);
    }
}
