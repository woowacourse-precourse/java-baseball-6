package baseball.util.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int LIMIT_NUMBER = 3;
    private static final int ZERO_NUMBER = 0;
    public static void validate(final int[] numbers){
        checkDuplicate(numbers);
        checkSize(numbers);
        checkZero(numbers);
    }

    private static void checkZero(int[] numbers) {
        for(int num: numbers){
            isZeroNum(num);
        }
    }

    private static void isZeroNum(int num) {
        if(num == ZERO_NUMBER){
            throw new IllegalArgumentException(ValidateMessage.ZERO_NUMBER_INPUT_ERROR.toString());
        }
    }

    private static void checkDuplicate(final int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int num: numbers){
            isDuplicateNum(num, set);
        }
    }

    private static void isDuplicateNum(int num, Set<Integer> set) {
        if(!set.add(num)){
            throw new IllegalArgumentException(ValidateMessage.DUPLICATE_ERROR.toString());
        }
    }

    private static void checkSize(final int[] numbers) {
        if(numbers.length!=LIMIT_NUMBER){
            throw new IllegalArgumentException(ValidateMessage.NOT_CORRECT_INPUT_SIZE.toString());
        }
    }
}
