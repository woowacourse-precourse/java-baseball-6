package baseball.player;

import baseball.common.Constants;
import baseball.common.ErrorConstants;
import java.util.ArrayList;
import java.util.List;

public class UserPlayer {

    private List<Integer> numbers = new ArrayList<>();

    public void updateUserNumbers(List<Integer> inputNumbers) {
        verify(inputNumbers);

        this.numbers = inputNumbers;
    }

    public void verify(List<Integer> inputNumbers) {
        if(inputNumbers.size() < Constants.minNumDigit) {
            throw new IllegalArgumentException(ErrorConstants.NO_INPUT_NUMBER_ERROR);
        }

        if(inputNumbers.size() > Constants.maxNumDigit) {
            throw new IllegalArgumentException(ErrorConstants.EXCEEDS_THREE_DIGITS_ERROR);
        }

        if(inputNumbers.stream().distinct().toList().size() != inputNumbers.size()) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NUMBER_ERROR);
        }

        if(inputNumbers.contains(Constants.invalidNum)) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_NUMBER_ERROR);
        }
    }

    public List<Integer> getUserNumbers(){
        return numbers;
    }
}
