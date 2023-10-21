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

        while (true) {
            System.out.print("3자리 숫자를 입력해주세요 : ");
            String input = scanner.nextLine();

            // 길이 검증
            if (input.length() != 3) {
                System.out.println("입력한 값이 3자리 수가 아닙니다. 다시 입력해주세요.");
                continue;
            }

            // 문자나 기호 포함 검증
            if (!input.matches("\\d{3}")) {
                System.out.println("숫자가 아닌 문자나 기호가 포함되어 있습니다. 다시 입력해주세요.");
                continue;
            }

            List<Integer> numbers = new ArrayList<>();
            boolean isValid = true;
            for (char c : input.toCharArray()) {
                int num = c - '0';
                // 범위 검증
                if (num < 1 || num > 9) {
                    System.out.println("입력된 숫자가 1부터 9의 범위를 벗어났습니다. 다시 입력해주세요.");
                    isValid = false;
                    break;
                }
                // 중복 검증
                if (numbers.contains(num)) {
                    System.out.println("중복된 숫자가 있습니다. 다시 입력해주세요.");
                    isValid = false;
                    break;
                }
                numbers.add(num);
            }

            if (isValid) {
                return numbers;
            }
        }
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = scanner.nextInt();

        return choice == 1;
    }
}

