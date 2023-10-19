package baseball.utill;

import java.util.List;

public class Validation {
    public boolean isInvalid(List<Integer> userNumbers) {
        return isNotNumber(userNumbers) || isNotThreeDigits(userNumbers) || hasDuplicatedNumbers(userNumbers);
    }

    private boolean isNotThreeDigits(List<Integer> userNumbers){
        return userNumbers.size() != 3;
    }

    private boolean isNotNumber(List<Integer> userNumbers){
        for (int number : userNumbers) {
            if (number < 1 || number > 9) return true;
        }
        return false;
    }

    private boolean hasDuplicatedNumbers(List<Integer> userNumbers){
        int ones = userNumbers.get(0);
        int tens = userNumbers.get(1);
        int hundreds = userNumbers.get(2);

        return ones == tens || ones == hundreds || tens == hundreds;
    }

}
