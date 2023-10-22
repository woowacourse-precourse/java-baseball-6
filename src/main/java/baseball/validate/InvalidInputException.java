package baseball.validate;

import java.util.ArrayList;
import java.util.List;

public class InvalidInputException {

    public void checkInputForGame(String playerInputNums) {
        isEmpty(playerInputNums); // 입력이 비었을 경우
        isNull(playerInputNums); // 입력이 null일 경우
        isNumber(playerInputNums); // 숫자가 아닌 경우
        isThreeDigits(playerInputNums); // 3자리 수가 아닌 경우
        hasDistinctDigits(playerInputNums); // 3자리 수 중에 중복이 있는 경우
    }

    public void checkRestartChoice(String playerInputNum) {
        isEmpty(playerInputNum); // 입력이 비었을 경우
        isNull(playerInputNum); // 입력이 null일 경우
        isNumber(playerInputNum); // 숫자가 아닌 경우
        isOneOrTwo(playerInputNum); // 1과 2 외의 다른 수가 입력될 경우
    }

    private void isEmpty(String nums) {
        if (nums.isEmpty()) {
            System.out.println("입력값이 비었습니다!");
            throw new IllegalArgumentException();
        }
    }

    private void isNull(String nums) {
        if (nums == null) {
            System.out.println("null이 입력되었습니다!");
            throw new IllegalArgumentException();
        }
    }

    private void isNumber(String nums) {
        try {
            Integer.parseInt(nums);
        } catch (NumberFormatException ex) {
            System.out.println("숫자가 아닙니다!");
            throw new IllegalArgumentException();
        }
    }

    private void isThreeDigits(String nums) {
        if (nums.length() != 3) {
            System.out.println("3자리 수가 아닙니다!");
            throw new IllegalArgumentException();
        }
    }

    private void hasDistinctDigits(String nums) {
        List<String> num = new ArrayList<>();
        for (String s : nums.split("")) {
            if (!num.contains(s)) {
                num.add(s);
            }
        }
        if (num.size() != 3) {
            System.out.println("중복되는 숫자가 있습니다!");
            throw new IllegalArgumentException();
        }
    }

    private void isOneOrTwo(String num) {
        int numToInt = Integer.parseInt(num);
        if (numToInt != 1 && numToInt != 2) {
            System.out.println("1과 2만 입력 가능합니다!");
            throw new IllegalArgumentException();
        }
    }
}
