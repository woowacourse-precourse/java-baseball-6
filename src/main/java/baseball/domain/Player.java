package baseball.domain;

import java.util.List;

import static baseball.util.ConvertToListIntegerUtil.convertStringToListInteger;
import static baseball.util.InputUtil.inputGuessNumber;

public class Player {
    private List<Integer> guessNumber;

    public void generateGuessNumber() {
        String input = inputGuessNumber();
        guessNumber = convertStringToListInteger(input);
    }

    public List<Integer> getGuessNumber() {
        return guessNumber;
    }
}
