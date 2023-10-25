package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = generateRandomNumbers();

        while (true) {

            try {
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = Integer.parseInt(Console.readLine());

                if (choice == 2) {
                    System.out.println("게임을 종료합니다. 감사합니다!");
                    break;
                } else if (choice == 1) {
                    computer = generateRandomNumbers();
                } else {
                    throw new IllegalArgumentException("올바른 수를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 선택을 입력하세요.");
            }
        }
    }

}