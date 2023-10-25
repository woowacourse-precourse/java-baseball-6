package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;
        boolean gameStarted = false;

        while (continueGame) {
            if (!gameStarted) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                gameStarted = true;
            }

            int[] computerNumbers = generateRandomNumbers();

            boolean gameWon = false;
            while (!gameWon) {

                System.out.println("숫자를 입력해주세요: ");
                String userInput = scanner.nextLine();
                if (userInput.length() != 3) {
                    throw new IllegalArgumentException("입력값은 서로 다른 3자리의 수 이어야 합니다.");
                }
                int[] userNumbers = convertInputToNumbers(userInput);

                int strikes = getStrikes(computerNumbers, userNumbers);
                int balls = getBalls(computerNumbers, userNumbers);

                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                } else if(strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }
            }

            System.out.println("게임을 종료하려면 2, 계속하려면 1을 입력하세요.");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput != 1) {
                continueGame = false;
            }
        }

        scanner.close();
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int randomNum;
            do {
                randomNum = random.nextInt(9) + 1;
            } while (contains(numbers, randomNum, i));
            numbers[i] = randomNum;
        }

        return numbers;
    }

    private static int[] convertInputToNumbers(String input) {
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }

        return numbers;
    }

    private static int getStrikes(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    private static int getBalls(int[] computerNumbers, int[] userNumbers) {
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] != userNumbers[i] && contains(computerNumbers, userNumbers[i], computerNumbers.length)) {
                balls++;
            }
        }

        return balls;
    }

    private static boolean contains(int[] numbers, int number, int upto) {
        for (int i = 0; i < upto; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }

        return false;
    }
}
