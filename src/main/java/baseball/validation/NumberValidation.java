package baseball.validation;

import baseball.constant.MessageConstant;
import baseball.constant.NumberConstant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberValidation {

    public void validateInputNumber(String inputNumber) {
        List<Integer> userNumber = changeToList(inputNumber);
        validateNumberSize(userNumber);
        validateNumberRange(userNumber);

    }

    public List<Integer> changeToList(String inputNumber) {
        List<Integer> userNumber = Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return userNumber;
    }

    public void validateNumberSize(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException(MessageConstant.VALIDATE_SIZE_MESSAGE);
        }
    }

    public void validateNumberRange(List<Integer> userNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) <= NumberConstant.MIN_NUMBER || userNumber.get(i) >= NumberConstant.MAX_NUMBER) {
                throw new IllegalArgumentException(MessageConstant.VALIDATE_SIZE_MESSAGE);
            }
        }
    }


}
