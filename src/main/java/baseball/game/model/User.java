package baseball.game.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private final List<Integer> numArr;

    public static UserNumber of(int nums){
        return new UserNumber(nums);
    }


    private UserNumber(int nums) {
        validateNums(nums);
        List<Integer> numArr = new ArrayList<>();

        numArr.add(nums / 100);
        nums %= 100;
        numArr.add(nums / 10);
        numArr.add(nums %= 10);

        this.numArr = numArr;
    }
    public int getDigitNum(int digit){
        return numArr.get(digit);
    }
    private void validateNums(int num) {
        if(num > 999 || num < 100) throw new IllegalArgumentException("잘못된 입력");
    }
}
