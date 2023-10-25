package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();
            System.out.println("컴퓨터가 숫자를 선택했습니다.");

            int attempts = 0;
            while (true) {
                System.out.print("서로 다른 3자리 숫자를 입력하세요: ");
                String userInput = Console.readLine();

                if (!isValidInput(userInput)) {
                    System.out.println("올바른 입력이 아닙니다. 다시 시도하세요.");
                    continue;
                }

                int userNumber = Integer.parseInt(userInput);
                int[] userDigits = {userNumber / 100, (userNumber % 100) / 10, userNumber % 10};
                int strikes = 0;
                int balls = 0;

                for (int i = 0; i < 3; i++) {
                    if (userDigits[i] == computerNumbers.get(i)) {
                        strikes++;
                    } else if (computerNumbers.contains(userDigits[i])) {
                        balls++;
                    }
                }

                if (strikes == 3) {
                    System.out.println("3스트라이크! 모든 숫자를 맞혔습니다! 게임 종료");
                    break;
                } else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }
                attempts++;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            if (choice != 1) {
                System.out.println("게임을 종료합니다. 총 " + attempts + "번 시도하였습니다.");
                break;
            }
        }
    }

    static List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    static boolean isValidInput(String input) {
        return input.matches("[1-9]{3}") && input.chars().distinct().count() == 3;
    }
}


