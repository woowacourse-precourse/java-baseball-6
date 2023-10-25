package baseball.validation;

import baseball.constant.MessageConstant;
import baseball.constant.NumberConstant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberValidation {

    public List<Integer> validateInputNumber(String inputNumber) {
        List<Integer> userNumber = changeToList(inputNumber);
        validateNumberSize(userNumber);
        validateNumberRange(userNumber);
        validateDuplication(userNumber);

        return userNumber;
    }

    private List<Integer> changeToList(String inputNumber) {
        List<Integer> userNumber = Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return userNumber;
    }

    private void validateNumberSize(List<Integer> userNumber) {
        if (userNumber.size() != NumberConstant.INPUT_SIZE) {
            throw new IllegalArgumentException(MessageConstant.VALIDATE_SIZE_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> userNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) < NumberConstant.MIN_NUMBER || userNumber.get(i) > NumberConstant.MAX_NUMBER) {
                throw new IllegalArgumentException(MessageConstant.VALIDATE_RANGE_MESSAGE);
            }
        }
    }

    private void validateDuplication(List<Integer> userNumber) {
        if (userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(MessageConstant.VALIDATE_DUPLICATION_MESSAGE);
        }
    }

    public void validateInputChoice(int inputNumber) {
        if (inputNumber != NumberConstant.RESTART_NUMBER && inputNumber != NumberConstant.GAME_END_NUMBER) {
            throw new IllegalArgumentException(MessageConstant.VALIDATE_INPUT_CHOICE_MESSAGE);
        }
    }

}
