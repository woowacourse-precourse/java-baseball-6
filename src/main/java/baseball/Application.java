package baseball;

import static baseball.Result.STRIKE;
import static baseball.Result.BALL;
import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임의 흐름을 제어하기 위한 클래스. 잘못된 입력값을 받을 경우 IllegalArgumentException을 던질 수 있습니다.
 */
public class Application {
    private static final int ANSWER_SIZE = 3;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;

    public static void main(String[] args) {
        Player.size = ANSWER_SIZE;
        Player.upperBound = UPPER_BOUND;
        Player.lowerBound = LOWER_BOUND;

        out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (wantsReplay());
    }

    static void play() {
        Player pitcher = new Player();
        int[] result;

        do {
            Player hitter = new Player(readNumber());
            result = pitcher.compareWith(hitter);
            printResult(result);
        } while (!foundAnswer(result));
    }

    static List<Integer> readNumber() {
        out.print("숫자를 입력해주세요: ");
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

    static void printResult(int[] result) {
        if (result[STRIKE.getIndex()] > 0 && result[BALL.getIndex()] > 0) {
            out.printf("%d볼 %d스트라이크\n", result[BALL.getIndex()], result[STRIKE.getIndex()]);
        } else if (result[STRIKE.getIndex()] > 0) {
            out.printf("%d스트라이크\n", result[STRIKE.getIndex()]);
        } else if (result[BALL.getIndex()] > 0) {
            out.printf("%d볼\n", result[BALL.getIndex()]);
        } else if (result[STRIKE.getIndex()] == 0 && result[BALL.getIndex()] == 0) {
            out.println("낫싱");
        }
    }

    static boolean foundAnswer(int[] result) {
        if (result[STRIKE.getIndex()] == ANSWER_SIZE) {
            out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", ANSWER_SIZE);
            return true;
        }
        return false;
    }

    static boolean wantsReplay() {
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
