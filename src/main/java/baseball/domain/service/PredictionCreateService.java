package baseball.domain.service;

import baseball.constants.ErrorConst;
import baseball.domain.entity.Prediction;

import java.util.List;

public class PredictionCreateService {
    public Prediction createPrediction(final String input) {
        return new Prediction(convertStringToIntegerList(input));
    }

    private List<Integer> convertStringToIntegerList(final String input) {
        validateIfNull(input);

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private void validateIfNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorConst.NULL_INPUT.getMessage());
        }
    }
}
