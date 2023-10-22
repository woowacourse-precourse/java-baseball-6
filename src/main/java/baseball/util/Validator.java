package baseball.util;

import baseball.config.Config;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean isInvalid(List<Integer> userNumbers) {
        return isNotNumber(userNumbers) || isNotValidDigits(userNumbers) || hasDuplicatedNumbers(userNumbers);
    }

    public static boolean isInvalid(String restartInput) {
        return !restartInput.equals(InputView.RESTART) && !restartInput.equals(InputView.EXIT);
    }

    private static boolean isNotValidDigits(List<Integer> userNumbers){
        return userNumbers.size() != Config.getMaxNumbers();
    }

    private static boolean isNotNumber(List<Integer> userNumbers){
        for (int number : userNumbers) {
            if (number < Config.getStartInclusive() || number > Config.getEndInclusive()) return true;
        }
        return false;
    }

    private static boolean hasDuplicatedNumbers(List<Integer> userNumbers){
        List<Integer> temp = new ArrayList<>();
        for (int number : userNumbers) {
            if(temp.contains(number)) return true;
            temp.add(number);
        }
        return false;
    }

}
