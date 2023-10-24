package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String target = generateRandomNumber();

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = scanner.nextLine().trim();

                if (guess.isEmpty()) {
                    System.out.println("낫싱");
                    continue;
                }

                if (!isValidInput(guess)) {
                    scanner.close();
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }

                GuessResult result = evaluateGuess(target, guess);

                if (result.strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                    break;
                } else {
                    System.out.println(result.balls + "볼 " + result.strikes + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = scanner.nextLine().trim();

            if (!"1".equals(choice)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }


    private static String generateRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        Random rand = new Random();

        while (numberSet.size() < 3) {
            numberSet.add(rand.nextInt(9) + 1);
        }

        StringBuilder number = new StringBuilder();
        for (int num : numberSet) {
            number.append(num);
        }
        return number.toString();
    }

    private static boolean isValidInput(String input) {
        return input.matches("[1-9]{3}") && input.chars().distinct().count() == 3;
    }

    private static GuessResult evaluateGuess(String target, String guess) {
        int balls = 0;
        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess.charAt(i) == target.charAt(j)) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

        return new GuessResult(balls, strikes);
    }

    private static class GuessResult {
        int balls;
        int strikes;

        GuessResult(int balls, int strikes) {
            this.balls = balls;
            this.strikes = strikes;
        }
    }
}
