package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    // TODO: 원시값 1, 3, 9 포장하기
    private static final int ANSWER_SIZE = 3;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;

    static List<Integer> readNumber() {
        String input = Console.readLine();
        int n;

        try {
            n = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (n < LOWER_BOUND - 1 || n > 999) {
            throw new IllegalArgumentException();
        }

        int[] result = {n / 100, n / 10 % 10, n % 10};
        if (result[0] == result[1] || result[1] == result[2] || result[2] == result[0]) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(result)
                .boxed()
                .toList();
    }

    // TODO: else 분리
    static boolean wantsReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // TODO: else 분리, indent 줄이기
    static void play() {
        Player pitcher = new Player();

        while (true) {
            Player hitter = new Player(readNumber());
            int[] result = pitcher.compareWith(hitter);
            if (result[1] > 0 && result[0] > 0) {
                System.out.printf("%d볼 %d스트라이크\n", result[1], result[0]);
            } else if (result[0] > 0) {
                System.out.printf("%d스트라이크\n", result[0]);
            } else if (result[1] > 0) {
                System.out.printf("%d볼\n", result[1]);
            } else {
                System.out.println("낫싱");
            }
            if (result[0] == ANSWER_SIZE) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Player.size = ANSWER_SIZE;
        Player.upperBound = UPPER_BOUND;
        Player.lowerBound = LOWER_BOUND;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (wantsReplay());
    }
}
