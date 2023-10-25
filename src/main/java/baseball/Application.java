// Application.java

package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Application {
    private static final int DIGIT_COUNT = 3;

    private int[] computerNumbers;

    public Application() {
        generateComputerNumbers();
    }

    private void generateComputerNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < DIGIT_COUNT) {
            uniqueNumbers.add(random.nextInt(9) + 1);
        }

        computerNumbers = new int[DIGIT_COUNT];
        int index = 0;
        for (int number : uniqueNumbers) {
            computerNumbers[index++] = number;
        }
    }

    private boolean validateInput(String input) {
        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력한 숫자는 3자리여야 합니다.");
        }

        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!Character.isDigit(digit) || digit == '0' || !uniqueDigits.add(digit)) {
                throw new IllegalArgumentException("1부터 9까지의 서로 다른 숫자로 입력해야 합니다.");
            }
        }

        return true;
    }

    private int countStrikes(int[] guess) {
        int strikes = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (guess[i] == computerNumbers[i]) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(int[] guess) {
        int balls = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            for (int j = 0; j < DIGIT_COUNT; j++) {
                if (i != j && guess[i] == computerNumbers[j]) {
                    balls++;
                }
            }
        }
        return balls;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String userInput = scanner.nextLine();

            try {
                if (!validateInput(userInput)) {
                    System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                    System.exit(0);
                }

                int[] userGuess = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();

                int strikes = countStrikes(userGuess);
                int balls = countBalls(userGuess);

                if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else if (strikes == DIGIT_COUNT) {
                    System.out.println("축하합니다! 정답을 맞추셨습니다.");
                    break;
                } else {
                    System.out.println(strikes + "스트라이크 " + balls + "볼");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                System.exit(0);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.playGame();
    }
}


