package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    public static void playGame() {
        Random random = new Random();
        int[] computerNumbers = generateRandomNumbers(random);
        boolean isGameWon = false;

        while (!isGameWon) {
            int[] userNumbers = getUserInput();
            int[] result = compareNumbers(computerNumbers, userNumbers);

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameWon = true;
            } else {
                displayResult(result);
            }
        }

        int choice = getRestartOrExitChoice();
        if (choice == 1) {
            playGame();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }

    public static int[] generateRandomNumbers(Random random) {
        int[] numbers = new int[3];
        boolean[] used = new boolean[10];

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

    public static int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        String input;
        do {
            System.out.print("숫자를 입력해주세요: ");
            input = scanner.nextLine();
        } while (!isValidInput(input));

        for (int i = 0; i < 3; i++) {
            char digit = input.charAt(i);
            numbers[i] = digit - '0';
        }

        return numbers;
    }

    public static boolean isValidInput(String input) {
        if (input.length() != 3) {
            System.out.println("3자리의 숫자를 입력해야 합니다.");
            return false;
        }

        for (int i = 0; i < 3; i++) {
            char digit = input.charAt(i);
            if (digit < '1' || digit > '9') {
                System.out.println("1에서 9 사이의 서로 다른 숫자를 입력해야 합니다.");
                return false;
            }
        }

        return true;
    }

    public static int[] compareNumbers(int[] computerNumbers, int[] userNumbers) {
        int[] result = new int[2];

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                result[1]++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (computerNumbers[i] == userNumbers[j]) {
                        result[0]++;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }

    public static int getRestartOrExitChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        return scanner.nextInt();
    }
}