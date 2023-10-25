package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public static void playGame() {
        List<Integer> computerNumbers = generateRandomNumbers();

        while (true) {
            List<Integer> userNumbers = getUserInput();
            List<Integer> result = checkGuess(computerNumbers, userNumbers);
            int strike = result.get(0);

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (playAgain()) {
                    computerNumbers = generateRandomNumbers();
                } else {
                    break;
                }
            } else {
                displayResult(result);
            }
        }
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

    public static List<Integer> getUserInput() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            int a = number % 10;
            int b = number / 10;
            if (numbers.contains(a)) {
                throw new IllegalArgumentException();
            } else {
                numbers.add(number);
                number = b;
            }
        }
        Collections.reverse(numbers);
        return numbers;
    }

    public static List<Integer> checkGuess(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikes++;
            } else if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }

        return List.of(strikes, balls);
    }

    public static void displayResult(List<Integer> result) {
        if (result.get(0) == 0 && result.get(1) == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result.get(1) + "볼 " + result.get(0) + "스트라이크");
        }
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1;
    }
}
