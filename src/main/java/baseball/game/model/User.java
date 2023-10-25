package baseball.game.model;

import baseball.game.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> numArr;

    public static User of(String nums) {
        return new User(nums);
    }


    private User(String userInput) {
        Validator.validIsInteger(userInput);
        int nums = Integer.parseInt(userInput);
        Validator.validDigit(nums);
        List<Integer> numArr = new ArrayList<>();

        numArr.add(nums / 100);
        nums %= 100;
        numArr.add(nums / 10);
        numArr.add(nums %= 10);

        this.numArr = numArr;
    }

    public int getDigitNum(int digit) {
        return numArr.get(digit);
    }
}
