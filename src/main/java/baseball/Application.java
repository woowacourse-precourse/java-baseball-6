package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임의 흐름을 제어하기 위한 클래스.
 * <p>
 * 사용자에게 입력값을 받고 각 클래스에게 전달합니다. 각 클래스의 출력값을 사용자에게 전달합니다.
 * <p>
 * 잘못된 입력값을 받을 경우 IllegalArgumentException을 던질 수 있습니다.
 */
public class Application {
    private static final int ANSWER_SIZE = 3;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;

    public static void main(String[] args) {
        Preference preference = new Preference(ANSWER_SIZE, LOWER_BOUND, UPPER_BOUND);

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Game.start(preference);
        } while (wantsReplay());
    }

    static List<Integer> readNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        int parsedInput = parseInt(input);
        validateRange(parsedInput);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= ANSWER_SIZE; i++) {
            int eachDigit = parsedInput / (int) Math.pow(10.0, ANSWER_SIZE - i) % 10;
            validateDuplicates(result, eachDigit);
            validateEachRange(eachDigit);
            result.add(eachDigit);
        }
        return result;
    }

    static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void validateRange(int parsedInput) {
        if (parsedInput < LOWER_BOUND - 1 || parsedInput > Math.pow(10.0, ANSWER_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    static void validateDuplicates(List<Integer> list, int digit) {
        if (list.contains(digit)) {
            throw new IllegalArgumentException();
        }
    }

    static void validateEachRange(int eachDigit) {
        if (eachDigit < LOWER_BOUND || eachDigit > UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    static void printResult(Result result) {
        if (result.strike() > 0 && result.ball() > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result.strike(), result.ball());
        } else if (result.strike() > 0) {
            System.out.printf("%d스트라이크\n", result.strike());
        } else if (result.ball() > 0) {
            System.out.printf("%d볼\n", result.ball());
        } else if (result.strike() == 0 && result.ball() == 0) {
            System.out.println("낫싱");
        }
    }

    static boolean wantsReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
