package baseball.validate;

import java.util.ArrayList;
import java.util.List;

public class InvalidInputException {

    public void checkInputForGame(String playerInputNum, int size) {
        isEmpty(playerInputNum); // 입력이 비었을 경우
        isNull(playerInputNum); // 입력이 null일 경우
        isNumber(playerInputNum); // 숫자가 아닌 경우
        isSingleOrThreeDigitNumber(playerInputNum, size); // 길이가 알맞은지
        if (size == 1) isOneOrTwo(playerInputNum);
        if (size == 3) hasDistinctDigits(playerInputNum);
    }

    private void isSingleOrThreeDigitNumber(String playerInputNum, int size) {
        if (playerInputNum.length() != size) {
            System.out.println("길이가 틀렸당~!");
            throw new IllegalArgumentException();
        }
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
