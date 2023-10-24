package baseball.util.validator;

import baseball.util.error.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int LIMIT_NUMBER = 3;
    private static final int ZERO_NUMBER = 0;
    private static final String NUM_CONDITION = "^[0-9]+$";
    public static int[] validate(final String numbers){
        checkCharacter(numbers);
        int[] numArray = parseNumbers(numbers);
        checkDuplicate(numArray);
        checkSize(numArray);
        checkZero(numArray);
        return numArray;
    }

    private static void checkZero(final int[] numbers) {
        for(int num: numbers){
            isZeroNum(num);
        }
    }

    private static void isZeroNum(final int num) {
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

    private static void isDuplicateNum(final int num, final Set<Integer> set) {
        if(!set.add(num)){
            throw new IllegalArgumentException(ValidateMessage.DUPLICATE_ERROR.toString());
        }
    }

    private static void checkSize(final int[] numbers) {
        if(numbers.length!=LIMIT_NUMBER){
            throw new IllegalArgumentException(ValidateMessage.NOT_CORRECT_INPUT_SIZE.toString());
        }
    }
    private static void checkCharacter(String nums) {
        if (!isValidInput(nums)) {
            throw new IllegalArgumentException(ValidateMessage.WRONG_INPUT.toString());
        }
    }

    private static boolean isValidInput(String input) {
        //                          정규표현식을 사용한다.
        return input.matches(NUM_CONDITION);
    }

    private static int[] parseNumbers(String input) {
        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
