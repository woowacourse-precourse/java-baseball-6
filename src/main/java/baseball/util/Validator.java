package baseball.util;

import baseball.en.NumExceptionEnum;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    public static void checkRxNums(String numsInput, int numSize) {

        isCorrectSize(numsInput, numSize);

        isNumber(numsInput);

        isAllNumUnique(numsInput);

    }

    private static void isAllNumUnique(String numsInput){
        ArrayList<Character> nums = new ArrayList<>();

        for(char num : nums) {
            if (nums.contains(num)){
                throw new IllegalArgumentException(NumExceptionEnum.DUPLICATION.msg);
            }
            nums.add(num);
        }
    }
    public static void isCorrectSize(String numsInput, int numSize) {
        if (numsInput.length() != numSize) {
            throw new IllegalArgumentException(NumExceptionEnum.WRONG_SIZE_NUM.msg);
        }
    }

    public static void isNumber(String value){
        if (value != null && !value.matches("^[^0]\\d*")){
            throw new IllegalArgumentException(NumExceptionEnum.NOT_INTEGER.msg);
        }
    }
}
