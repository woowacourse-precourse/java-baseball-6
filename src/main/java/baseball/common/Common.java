package baseball.common;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BallConst.*;

public class Common {

    public static List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < BALL_COUNT) {
            int ball = Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM);
            if (!computer.contains(ball)) {
                computer.add(ball);
            }
        }
        return computer;
    }

    public static void validateInput(String input) {
        validateLength(input);
        validateIsString(input);
        validateDifferent(input);
    }


    public static void validateRetryInput(String input) {
        validateRetryIsOneOrTwo(input);
        validateRetryLength(input);
        validateIsString(input);
    }

    private static void validateRetryLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("입력 값이 1자리가 아니므로 종료합니다.");
        }
    }

    private static void validateRetryIsOneOrTwo(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("입력 값이 1또는 2이 아니므로 종료합니다.");
    }

    private static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값이 3자리가 아니므로 종료합니다.");
        }
    }

    private static void validateIsString(String input) {
        for (char ch : input.toCharArray()) {
            if (ch == '0' || !Character.isDigit(ch)) {
                throw new IllegalArgumentException("정상적인 입력값이 아니므로 종료합니다.");
            }
        }
    }

    private static void validateDifferent(String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("중복된 숫자입력으로 종료합니다");
        }
    }

}
