package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readGuess() {
        String guess = readLine();
        validateNumberString(guess);

        return guess;
    }

    private void validateNumberString(String guess) {
        if (!guess.matches("^[0-9]*$")) {
            throw new NotNumberStringException();
        }
    }

    private String readLine() {
        return Console.readLine().replaceAll(" ", "");
    }

    public static class NotNumberStringException extends IllegalAccessError{
    }


}
