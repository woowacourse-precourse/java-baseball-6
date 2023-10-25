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

    public static void main(String[] args) {

    }
}
