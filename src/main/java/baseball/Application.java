package baseball;

import utils.Random;
import static calculate.calcuate.Hint;
import static calculate.calcuate.calculateResult;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;



public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameStart();
    }

    public static void GameStart() {
        while (true) {
            List<Integer> computerNumbers = Random.generateRandomNumbers();
            System.out.println("랜덤으로 생성된 3개의 숫자를 맞춰보세요.");
            int attempts = 0;

            while (true) {
                int[] userNumbers = InputNumber();
                int[] result = calculateResult(computerNumbers, userNumbers);
                Hint(result);

                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                attempts++;
            }

            if (!playAgain()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static int[] InputNumber() {
        int[] userNumbers = new int[3];

        System.out.print("숫자를 입력하세요: ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException("올바른 3자리 숫자를 입력하세요.");
        }

        for (int i = 0; i < 3; i++) {
            userNumbers[i] = input.charAt(i) - '0';
        }
        return userNumbers;
    }

    public static boolean playAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String choice = Console.readLine();
        return choice.equals("1");
    }
}
