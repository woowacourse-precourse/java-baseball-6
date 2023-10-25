package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserController {

    public String receiveUserInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void checkStringLength(String nums, int length) {
        if (nums.length() != length) {
            throw new IllegalArgumentException("3자릿수를 입력해주세요.");
        }
    }

    public int checkInt(String nums) throws IllegalArgumentException {
        try {
            return Integer.parseInt(nums);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void checkDuplicated(List<Integer> nums, int size) throws IllegalArgumentException {
        if (nums.stream().distinct().count() != size) {
            throw new IllegalArgumentException("서로 다른 3개의 수를 입력해주세요.");
        }
    }

}
