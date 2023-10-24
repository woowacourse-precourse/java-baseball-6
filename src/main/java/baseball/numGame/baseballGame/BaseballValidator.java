package baseball.numGame.baseballGame;

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

}
