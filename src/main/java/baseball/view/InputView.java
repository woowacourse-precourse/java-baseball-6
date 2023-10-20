package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readGuessNumbers() {
        String inputString = Console.readLine();
        validateDigit(inputString);
        return inputString;
    }

    private void validateDigit(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
