package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NUM = 9;
    private static final int NUM_SIZE = 3;

    public static void main(String[] args) {
        do {
            playGame();
        } while (keepGoing());
    }
    private static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, MAX_NUM);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUM_SIZE) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해 주세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private static int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < NUM_SIZE; i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int countBalls(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < NUM_SIZE; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static void playGame() {
        List<Integer> computerNumbers = makeRandomNumbers();

        while (true) {
            List<Integer> userNumbers = inputNumbers();

            int strikes = countStrikes(computerNumbers, userNumbers);
            int balls = countBalls(computerNumbers, userNumbers);

            if (strikes == NUM_SIZE) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

            if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
                continue;
            }

            if (balls > 0) {
                System.out.print(balls + "볼 ");
            }

            if (strikes > 0) {
                System.out.print(strikes + "스트라이크");
            }

            System.out.println();
        }
    }

    private static boolean keepGoing() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return "1".equals(input);
    }

}
