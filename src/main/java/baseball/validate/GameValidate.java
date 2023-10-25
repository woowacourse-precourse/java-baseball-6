package baseball.validate;

import baseball.model.BaseballGameRule;
import java.util.List;

public class GameValidate extends BaseballGameRule {
    public static void gameGuessNumbersCheck(List<Integer> givenNumbers) {
        isCorrectSize(givenNumbers);
        isNumberInRange(givenNumbers);
    }

    public static boolean isCorrectSize(List<Integer> numbers) {
        if(numbers.size()==BASEBALL_MAX_AMOUNT) return true ;
        throw new IllegalArgumentException("Wrong Size Numbers");
    }
    public static boolean isNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException("Wrong Range Number");
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
