package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUM_DIGITS = 3;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != NUM_DIGITS || !input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            int num = ch - '0';
            if (!numbers.contains(num)) {
                numbers.add(num);
            } else {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
            }
        }
        return numbers;
    }

    private static void showResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }

    private static boolean checkRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        return "1".equals(input);
    }

    private static boolean playGame() throws IllegalArgumentException {
        List<Integer> computer = generateRandomNumbers();
        boolean[] comVisited = new boolean[MAX_NUMBER + 1];
        for (Integer num : computer) {
            comVisited[num] = true;
        }

        while (true) {
            List<Integer> user = getUserInput();

            int strike = 0;
            int ball = 0;
            for (int i = 0; i < NUM_DIGITS; i++) {
                int comNum = computer.get(i);
                int myNum = user.get(i);

                if (comNum == myNum) {
                    strike++;
                    continue;
                }

                if (comVisited[myNum]) {
                    ball++;
                }
            }

            showResult(ball, strike);

            if (strike == NUM_DIGITS) {
                return checkRestart();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (!playGame()) {
                break;
            }
        }
    }
}
