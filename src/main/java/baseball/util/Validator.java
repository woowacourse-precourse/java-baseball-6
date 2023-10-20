package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {
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
        if(numbers.length>3){
            throw new IllegalArgumentException("세 자리 숫자를 입력 해주세요.");
        }
    }
}
