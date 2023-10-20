package baseball.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidationTest {
    public static final int LIMIT_NUMBER = 3;

    @Test
    void inputCheck_ok(){
        String nums = "123";
        checkSize(nums);
        int[] numbers = Arrays.stream(nums.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(!checkDuplicate(numbers)){
            throw new IllegalArgumentException("중복된 숫자를 입력 하지 마세요");
        }
        assert numbers[0] == 1;
    }

    private static boolean checkDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int num: numbers){
            if (isAlreadyIn(num, set)) return false;
        }
        return true;
    }

    private static boolean isAlreadyIn(int num, Set<Integer> set) {
        if(!set.add(num)){
            return true;
        }
        return false;
    }

    private static void checkSize(String nums) {
        if(nums.length()>3){
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
    }
}
