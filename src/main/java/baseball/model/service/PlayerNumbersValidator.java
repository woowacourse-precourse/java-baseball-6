package baseball.model.service;

import java.util.List;

public interface PlayerNumbersValidator {
    void isNonNumber(String inputNumbers);

    void isLengthCorrect(List<Integer> convertNumbers);

    void isRange(List<Integer> convertNumbers);

    void isDuplicate(List<Integer> convertNumbers);
}
