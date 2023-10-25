package baseball.validate;

import baseball.model.BaseballGameRule;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameValidate extends BaseballGameRule {
    public static void gameGuessNumbersCheck(List<Integer> givenNumbers) {
        if (isCorrectSize(givenNumbers) && isCorrectSize(givenNumbers) && isNumberInRange(
            givenNumbers)) {
            return;
        }
        throw new IllegalArgumentException("Wrong Guess Input Violate Rules");
    }

    public static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size()==BASEBALL_MAX_AMOUNT;
    }
    public static boolean isNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isInRange(number)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isInRange(int givenNumber) {
        return BASEBALL_MIN_VALUE <= givenNumber && givenNumber <= BASEBALL_MAX_VALUE;
    }
    public static void gameRestartNumberCheck(Integer givenNumber) {
        if (givenNumber.equals(BASEBALL_GAME_RESTART)  || givenNumber.equals(BASEBALL_GAME_FINISH)) {
            return;
        }
        throw new IllegalArgumentException("Wrong Restart Input");
    }
}
