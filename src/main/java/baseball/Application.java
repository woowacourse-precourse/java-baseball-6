package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            playGame();

            System.out.print("게임을 다시 시작하시겠습니까? (y/n): ");
            String response = Console.readLine();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    private static void playGame() {
        List<Integer> computerNumbers = generateRandomNumbers();
        int attempts = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("1부터 9까지 서로 다른 숫자 3개를 맞춰보세요.");

        while (true) {
            List<Integer> userGuess = getUserGuess();
            int[] result = calculateResult(computerNumbers, userGuess);
            attempts++;

            if (result[0] == 3) {
                System.out.println("축하합니다! 모든 숫자를 맞히셨습니다. 시도 횟수: " + attempts);
                break;
            } else {
                System.out.println("결과: " + result[0] + " 스트라이크, " + result[1] + " 볼");
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserGuess() {
        List<Integer> userGuess = new ArrayList<>();
        while (userGuess.size() < 3) {
            System.out.print("3개의 숫자를 입력하세요: ");
            try {
                int number = Integer.parseInt(Console.readLine());
                if (number < 1 || number > 9) {
                    System.out.println("1부터 9 사이의 숫자를 입력하세요.");
                    continue;
                }
                if (userGuess.contains(number)) {
                    System.out.println("이미 입력한 숫자입니다. 다른 숫자를 입력하세요.");
                    continue;
                }
                userGuess.add(number);
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }
        return userGuess;
    }

    private static int[] calculateResult(List<Integer> computerNumbers, List<Integer> userGuess) {
        int[] result = new int[2]; // result[0] - 스트라이크, result[1] - 볼

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userGuess.get(i))) {
                result[0]++; // 스트라이크 증가
            } else if (computerNumbers.contains(userGuess.get(i))) {
                result[1]++; // 볼 증가
            }
        }

        return result;
    }
}
