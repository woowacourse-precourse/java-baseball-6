package baseball.validate;

import static baseball.validate.NumberValidate.BALL_SIZE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidate {

    public static void gameGuessNumbersCheck(List<Integer> givenNumbers) {
        if (isCorrectSize(givenNumbers) && isCorrectSize(givenNumbers) && isNumberInRange(
            givenNumbers)) {
            return;
        }
        throw new IllegalArgumentException("Wrong Guess Input Violate Rules");
    }

    public static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == BALL_SIZE;
    }

    public static boolean isNumberNotDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() == numbersSet.size();
    }

    public static boolean isNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!NumberValidate.isInRange(number)) {
                return false;
            }
        }
        return true;
    }

    public static void isAllNumbers(String numbers) {
        Arrays.stream(numbers.split(""))
            .map(NumberValidate::isNumber).toList();
    }

    public static void gameRestartNumberCheck(Integer givenNumber) {
        if (givenNumber == 1 || givenNumber == 2) {
            return;
        }
        throw new IllegalArgumentException("Wrong Restart Input");
    }
}
