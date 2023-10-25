package baseball.Model;

import baseball.View.InputView;
import java.util.stream.IntStream;

public class UserNumberPicker {
    public final int[] user;

    public UserNumberPicker() throws IllegalArgumentException {
        String userInput = InputView.requestBaseballNumber();
        if(isException(userInput)) {
            throw new IllegalArgumentException();
        }
        this.user = convertStringToIntArray(userInput);
    }

    private int[] convertStringToIntArray(String userInput) {
        int[] user = IntStream.range(0, GameConstant.MAX_NUM)
                .map(i -> userInput.charAt(i) - '0')
                .toArray();
        return user;
    }

    private boolean isException(String userInput) {
        return !Exception.isNumber(userInput)
                || Exception.hasDuplicates(userInput)
                || !Exception.isValidLength(userInput)
                || Exception.containsZero(userInput);
    }
}
