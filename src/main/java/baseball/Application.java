package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static class Result {
        private final int balls;
        private final int strikes;

        public Result(int balls, int strikes) {
            this.balls = balls;
            this.strikes = strikes;
        }

        public int getBalls() {
            return balls;
        }

        public int getStrikes() {
            return strikes;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> computerNumbers = generateRandomNumbers();
            boolean isCorrect = false;

            while (!isCorrect) {
                List<Integer> userInput = getUserInput();
                Result result = compareNumbers(userInput, computerNumbers);
                printResult(result);
                isCorrect = (result.getStrikes() == 3);
            }

        } while (isGameContinued());
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }

    private static List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("3자리 숫자를 입력해주세요 : ");

        String input = scanner.nextLine();
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(c - '0');
        }

        return numbers;
    }

    private static Result compareNumbers(List<Integer> userInput, List<Integer> computerNumbers) {
        int balls = 0;
        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            if (userInput.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userInput.get(i))) {
                balls++;
            }
        }

        return new Result(balls, strikes);
    }

    private static void printResult(Result result) {
        if (result.getBalls() == 0 && result.getStrikes() == 0) {
            System.out.println("낫싱");
        } else if (result.getStrikes() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(result.getBalls() + "볼 " + result.getStrikes() + "스트라이크");
        }
    }

    private static boolean isGameContinued() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 계속하시겠습니까? (1: 재시작, 2: 종료)");
        int choice = scanner.nextInt();

        return choice == 1;
    }
}

