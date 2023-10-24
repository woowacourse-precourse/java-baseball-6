package baseball.baseballGame;

import baseball.game.Validator;
import java.util.List;

public class BaseballValidator implements Validator {
    private Integer minOfRange;
    private Integer maxOfRange;
    private Integer numOfNumbers;
    private Integer playOption;
    private Integer endOption;


    @Override
    public void validateReplayOption(Integer option) {
        if (!option.equals(playOption) && !option.equals(endOption)) {
            throw new IllegalArgumentException();
        }
    }

    BaseballValidator(BaseballConfig config) {
        minOfRange = config.getMinOfRange();
        maxOfRange = config.getMaxOfRange();
        numOfNumbers = config.getNumOfNumbers();
        playOption = config.getPlayOption();
        endOption = config.getEndOption();
    }

    public void validateLength(String input) {
        if (input.length() != numOfNumbers) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(char number) {
        if (number < minOfRange + '0' || number > maxOfRange + '0') {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(char cur, List<Integer> inputList) {
        if (inputList.contains(cur - '0')) {
            throw new IllegalArgumentException();
        }
    }
}
