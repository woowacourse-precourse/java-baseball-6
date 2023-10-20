package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static boolean validate(int[] numbers){
        if(checkDuplicate(numbers)){
            throw new IllegalArgumentException("중복된 숫자를 입력 하지 마세요.");
        }
        if(checkSize(numbers)){
            throw new IllegalArgumentException("세 자리 숫자를 입력 해주세요.");
        }
        return true;
    }

    private static boolean checkDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int num: numbers){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkSize(int[] numbers) {
        if(numbers.length>3){
            return true;
        }
        return false;
    }
}
