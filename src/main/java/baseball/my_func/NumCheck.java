package baseball.my_func;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumCheck {

    public static void isValidBalls(List<Integer> nums) {
        isSize(nums.size()); // 사이즈 3개 확인
        isDuplication(nums); // 중복 검사
    }

    public static void isValidBallNo(char num) {
        isNum(num); // 0~9 숫자 검사
        isNotZero(num); // 0검사
    }

    private static void isSize(int inputSize) {
        if (inputSize != 3) {
            throw new IllegalArgumentException("입력 숫자는 총 3개여야 합니다.");
        }
    }

    private static void isDuplication(List<Integer> num) {
        Set<Integer> duplicateChecker = new HashSet<>(num);
        if (duplicateChecker.size() != 3) {
            throw new IllegalArgumentException("입력 숫자 중 중복된 숫자는 존재할 수 없습니다.");
        }
    }

    private static void isNum(char num) {
        if (!Character.isDigit(num)) {
            throw new IllegalArgumentException("입력은 숫자만 허용합니다.");
        }
    }

    private static void isNotZero(char num) {
        if (num == 48) {
            throw new IllegalArgumentException("입력은 1 ~ 9 사이의 수만 허용합니다.");
        }
    }

    public static void choiceGameMenu(String gameCode) {
        if (!gameCode.equals("1") && !gameCode.equals("2")) {
            throw new IllegalArgumentException("재시작/종료 코드는 1 혹은 2입니다.");
        }
    }
}
