package baseball.util;

import java.util.List;

public class ValidationChecking {
    public void checkUserInputValidate(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException();
        }

        for (Integer number : userNumber) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
