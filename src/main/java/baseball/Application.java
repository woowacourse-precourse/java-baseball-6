package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int ANSWER_SIZE = 3;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;

    public static void main(String[] args) {
        Player.size = ANSWER_SIZE;
        Player.upperBound = UPPER_BOUND;
        Player.lowerBound = LOWER_BOUND;

        System.out.println("숫자 야구 게임을 시작합니다.");
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
        String input = Console.readLine();
        int parsedInput = parseInt(input);
        validateRange(parsedInput);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= ANSWER_SIZE; i++) {
            int eachDigit = parsedInput / (int) Math.pow(10.0, ANSWER_SIZE - i) % 10;
            validateDuplicates(result, eachDigit);
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

    static void printResult(int[] result) {
        if (result[1] > 0 && result[0] > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result[1], result[0]);
        } else if (result[0] > 0) {
            System.out.printf("%d스트라이크\n", result[0]);
        } else if (result[1] > 0) {
            System.out.printf("%d볼\n", result[1]);
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
    }

    static boolean foundAnswer(int[] result) {
        if (result[0] == ANSWER_SIZE) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", ANSWER_SIZE);
            return true;
        }
        return false;
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
