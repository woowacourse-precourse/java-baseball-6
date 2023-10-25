package baseball;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean isGameRunning = true;

        while (isGameRunning) {
            int[] computerNumbers = generateRandomNumbers();
            int tries = 0;

            System.out.println("숫자 야구 게임을 시작합니다!");

            while (true) {
                System.out.print("3자리 숫자를 입력하세요: ");
                int userGuess = scanner.nextInt();
                if (!isValidGuess(userGuess)) {
                    System.out.println("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력하세요.");
                    continue;
                }

                int result = checkGuess(userGuess, computerNumbers);
                if (result == 30) {
                    System.out.println("3스트라이크! 게임에서 승리하셨습니다!");
                    break;
                } else {
                    int strikes = result / 10;
                    int balls = result % 10;
                    if (strikes == 0 && balls == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.println(strikes + "스트라이크 " + balls + "볼");
                    }
                }

                tries++;
            }

            System.out.println("게임 종료! 시도한 횟수: " + tries);
            System.out.print("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = scanner.nextInt();
            if (choice == 2) {
                isGameRunning = false;
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = (int) (Math.random() * 9) + 1;
            } while (contains(numbers, num));
            numbers[i] = num;
        }
        return numbers;
    }

    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidGuess(int guess) {
        return guess >= 100 && guess <= 999 && hasUniqueDigits(guess);
    }

    private static boolean hasUniqueDigits(int number) {
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits[0] != digits[1] && digits[0] != digits[2] && digits[1] != digits[2];
    }

    private static int checkGuess(int guess, int[] target) {
        int result = 0;
        int[] guessDigits = new int[3];
        for (int i = 2; i >= 0; i--) {
            guessDigits[i] = guess % 10;
            guess /= 10;
        }

        for (int i = 0; i < 3; i++) {
            if (guessDigits[i] == target[i]) {
                result += 10;  
            } else if (contains(target, guessDigits[i])) {
                result += 1;
            }
        }

        return result;
    }
}

