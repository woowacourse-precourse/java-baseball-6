package baseball;

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int MAX_ATTEMPTS = 10;
    private static final int DIGIT_COUNT = 3;

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = scanner.nextInt();
            playAgain = (choice == 1);
        }

        System.out.println("게임 종료!");
    }

    private static void playGame() {
        Random random = new Random();
        int[] computerNumber = generateComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] userGuess = getUserGuess();;
        for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
            userGuess = getUserGuess();

            int strikes = countStrikes(computerNumber, userGuess);
            int balls = countBalls(computerNumber, userGuess);

            if (strikes == DIGIT_COUNT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

            System.out.println(strikes + "스트라이크 " + balls + "볼");
        }

        System.out.println("시도 횟수를 모두 사용했습니다. 정답은 " + getNumberAsString(computerNumber) + "입니다.");

        // 게임을 다시 시작할 때, 이전 게임의 결과를 초기화합니다.
        computerNumber = generateComputerNumber();
    }



    private static int[] generateComputerNumber() {
        int[] number = new int[DIGIT_COUNT];
        Random random = new Random();
        Set<Integer> usedDigits = new HashSet<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int digit;
            do {
                digit = random.nextInt(9) + 1;
            } while (usedDigits.contains(digit));
            number[i] = digit;
            usedDigits.add(digit);
        }

        return number;
    }

    private static int[] getUserGuess() {
        int[] guess = new int[DIGIT_COUNT];
        Scanner scanner = new Scanner(System.in);

        System.out.print("3개의 숫자를 띄어쓰기 없이 입력하세요: ");
        String input = scanner.next();

        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
        }

        Set<Integer> usedDigits = new HashSet<>();
        for (int i = 0; i < DIGIT_COUNT; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            if (digit < 1 || digit > 9 || usedDigits.contains(digit)) {
                throw new IllegalArgumentException("1부터 9까지의 서로 다른 숫자를 입력하세요.");
            }

            guess[i] = digit;
            usedDigits.add(digit);
        }

        scanner.close(); // Close the Scanner object

        return guess;
    }

    private static int countStrikes(int[] computerNumber, int[] userGuess) {
        int strikes = 0;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (computerNumber[i] == userGuess[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    private static int countBalls(int[] computerNumber, int[] userGuess) {
        int balls = 0;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            for (int j = 0; j < DIGIT_COUNT; j++) {
                if (i != j && computerNumber[i] == userGuess[j]) {
                    balls++;
                }
            }
        }

        return balls;
    }

    private static String getNumberAsString(int[] number) {
        StringBuilder sb = new StringBuilder();

        for (int digit : number) {
            sb.append(digit);
        }

        return sb.toString();
    }
}


