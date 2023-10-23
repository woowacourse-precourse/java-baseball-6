package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {

    public static boolean duplicateChecker(int newNum, Integer[] computer) {
        for (int i = 0; i < computer.length - 1; i++) {
            if (computer[i] != null && computer[i] == newNum) {
                return false;
            }
        }
        return true;
    }

    public static int judgingStrike(String input, Integer[] computer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer[i] == (int) input.charAt(i) - '0') {
                count++;
            }
        }
        return count;
    }

    public static int judgingBall(String input, Integer[] computer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if ((int) input.charAt(i) - '0' == computer[(i + 1) % 3]) {
                count++;
            }
            if ((int) input.charAt(i) - '0' == computer[(i + 2) % 3]) {
                count++;
            }
        }
        return count;
    }

    public static boolean saying(String input, Integer[] computer) {
        int strike = judgingStrike(input, computer);
        int ball = judgingBall(input, computer);
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball > 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }
        }
        return true;
    }

    public static boolean converter(String num) {
        if ((int) num.charAt(0) - '0' == 1) {
            return true;
        }
        if ((int) num.charAt(0) - '0' == 2) {
            return false;
        }
        return false;
    }

    public static String checker(String input) {
        StringBuilder tmp = new StringBuilder();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 입력!");
        }
        for (char c : input.toCharArray()) {
            if (tmp.toString().contains(String.valueOf(c))) {
                throw new IllegalArgumentException("중복되지 않게 입력!");
            }
            tmp.append(String.valueOf(c));
        }
        return input;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean answer = true;
        boolean restart;

        do {
            Integer[] computer = new Integer[3];
            for (int i = 0; i < 3; i++) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (duplicateChecker(randomNumber, computer)) {
                    computer[i] = randomNumber;
                    continue;
                }
                i--;
            }
            do {
                String input = checker(Console.readLine());
                answer = saying(input, computer);
            } while (answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = converter(Console.readLine());
        } while (restart);
    }
}
