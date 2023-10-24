package baseball.utils;

import baseball.domain.BaseBall;
import baseball.validator.GenerateValidator;

public class HintGenerator {

    public BaseBall generateHint(int[] answer, int[] input) {
        GenerateValidator generateValidator = new GenerateValidator();
        generateValidator.validateInputLength(answer, input);

        BaseBall result = new BaseBall();
        for (int i = 0; i < answer.length; i++) {
            generateValidator.checkMatch(answer, input, i, result);
        }
        return result;
    }
}
