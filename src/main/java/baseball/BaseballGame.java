package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
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

        for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
            int[] userGuess = getUserGuess();

            int strikes = countStrikes(computerNumber, userGuess);
            int balls = countBalls(computerNumber, userGuess);

            if (strikes == DIGIT_COUNT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }else if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(strikes + "스트라이크 " + balls + "볼");
            }


            System.out.println(strikes + "스트라이크 " + balls + "볼");
        }

        System.out.println("시도 횟수를 모두 사용했습니다. 정답은 " + getNumberAsString(computerNumber) + "입니다.");    }

    private static int[] generateComputerNumber() {
        int[] number = new int[DIGIT_COUNT];
        Random random = new Random();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int digit;
            do {
                digit = random.nextInt(9) + 1;
            } while (containsDigit(number, digit));
            number[i] = digit;
        }

        return number;
    }

    private static boolean containsDigit(int[] number, int digit) {
        for (int n : number) {
            if (n == digit) {
                return true;
            }
        }
        return false;
    }

    private static int[] getUserGuess() {
        int[] guess = new int[DIGIT_COUNT];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < DIGIT_COUNT; i++) {
            System.out.print("숫자를 입력해주세요 : ");
            if (scanner.hasNextInt()) {
                int digit = scanner.nextInt();
                if (digit < 1 || digit > 9) {
                    throw new IllegalArgumentException("1부터 9까지의 숫자를 입력하세요.");
                }

                if (containsDigit(guess, digit)) {
                    throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
                }

                guess[i] = digit;
            } else {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력하세요.");
            }
        }

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
