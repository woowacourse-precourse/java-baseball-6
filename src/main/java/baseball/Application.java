package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;
        while (playAgain) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Console.readLine().charAt(0) - '0';
            playAgain = (choice == 1);
        }

        System.out.println("게임을 종료합니다. 안녕히 가세요!");
    }

    private static void playGame() {
        List<Integer> computerNumber = generateRandomNumbers();
        boolean gameWon = false;

        while (!gameWon) {
            List<Integer> userNumber = getUserInput();
            int strikes = countStrikes(computerNumber, userNumber);
            int balls = countBalls(computerNumber, userNumber);

            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameWon = true;
            } else if (strikes > 0 || balls > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    private static List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }
        return numbers;
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

    private static int countStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int countBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userNumber.get(i)) && !computerNumber.get(i).equals(userNumber.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}
