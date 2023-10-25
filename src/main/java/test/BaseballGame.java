package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    private static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = scanner.nextInt();
            playAgain = (choice == 1);
        } while (playAgain);
    }

    public static void playGame() {
        Random random = new Random();
        int[] computerNumbers = generateRandomNumbers();
        int[] userNumbers;

        System.out.println("숫자 야구 게임을 시작합니다. 1부터 9까지 서로 다른 3자리 숫자를 맞춰보세요.");

        do {
            userNumbers = getUserNumbers();
            result = compareNumbers(computerNumbers, userNumbers);
            displayResult(result);
        } while (result[0] < 3);

        System.out.println("게임 종료. 축하합니다!");
    }

    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        boolean[] used = new boolean[10];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = random.nextInt(9) + 1;
            } while (used[num]);
            numbers[i] = num;
            used[num] = true;
        }

        return numbers;
    }

    public static int[] getUserNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int number;
            do {
                System.out.print((i + 1) + "번째 숫자를 입력하세요 (1부터 9까지): ");
                number = scanner.nextInt();
            } while (number < 1 || number > 9);
            numbers[i] = number;
        }

        return numbers;
    }

    public static int[] compareNumbers(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computerNumbers.length; i++) {
            for (int j = 0; j < userNumbers.length; j++) {
                if (computerNumbers[i] == userNumbers[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

        return new int[]{strikes, balls};
    }

    public static void displayResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            String output = (strikes > 0) ? strikes + "스트라이크" : "";
            output += (balls > 0) ? (output.isEmpty() ? "" : " ") + balls + "볼" : "";
            System.out.println(output);
        }
    }
}

