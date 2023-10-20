package baseball.util.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int LIMIT_NUMBER = 3;
    public static boolean validate(final int[] numbers){
        checkDuplicate(numbers);
        checkSize(numbers);
        return true;
    }

    private static void checkDuplicate(final int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int num: numbers){
            if(!set.add(num)){
                throw new IllegalArgumentException("중복된 숫자를 입력 하지 마세요.");
            }
        }
    }

    private static void checkSize(final int[] numbers) {
        if(numbers.length!=LIMIT_NUMBER){
            throw new IllegalArgumentException("세 자리 숫자를 입력 해주세요.");
        }
    }
}
