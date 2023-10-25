package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateRandomNumbers();
            boolean gameEnded = false;

            while (!gameEnded) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> userNumbers = getUserInput();

                int strikes = countStrikes(computerNumbers, userNumbers);
                int balls = countBalls(computerNumbers, userNumbers);

                gameEnded = printResult(strikes, balls);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserInput() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine();

        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException(); // 예외 처리 추가
        }

        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (number < 1 || number > 9 || numbers.contains(number)) {
                throw new IllegalArgumentException();
            }
            numbers.add(number);
        }

        return numbers;
    }

    private static int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int countBalls(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();

        if (strikes == NUMBER_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
}


