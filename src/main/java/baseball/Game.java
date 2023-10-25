package baseball;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final int NUMBER_LENGTH = 3;
    private final String STRING_BALL = "볼";
    private final String STRING_STRIKE = "스트라이크";
    private final String STRING_NOTHING = "낫싱";
    private final String INPUT_RESTART = "1";
    private final String INPUT_QUIT = "2";

    private int strike;
    private int ball;
    private int randomNumber;
    private List<Integer> randomDigits;
    private List<Integer> userDigits;
    private boolean quit = false;

    public Game() {
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initializeRandomNumber();
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                int userNumber;
                try {
                    userNumber = scanner.nextInt();
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                if (userNumber < 100 || userNumber > 999) {
                    throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
                }

                if (!isUniqueDigits(userNumber)) {
                    throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
                }

                scanner.nextLine();

                separateNumberToDigits(userNumber);
                calculateBallAndStrike();
                displayBallAndStrike();
                if (strike == NUMBER_LENGTH) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String input = scanner.nextLine();

                    if (!input.equals(INPUT_RESTART) && !input.equals(INPUT_QUIT)) {
                        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
                    }

                    handleQuitOrRestart(input);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    private void initializeRandomNumber() {
        randomNumber = RandomNumberGenerator.generateRandomNumber(100, 899);
        randomDigits = NumberProcessor.getDigits(randomNumber);
    }

    private boolean isUniqueDigits(int number) {
        int[] digits = new int[10];
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digits[digit] > 0) {
                return false;
            }
            digits[digit]++;
            count++;
            number /= 10;
        }
        return count == NUMBER_LENGTH;
    }

    private void separateNumberToDigits(int number) {
        userDigits = NumberProcessor.getDigits(number);
    }

    private void calculateBallAndStrike() {
        strike = NumberProcessor.calculateStrikeCount(randomDigits, userDigits);
        ball = NumberProcessor.calculateBallCount(randomDigits, userDigits);
    }


    private void displayBallAndStrike() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = STRING_NOTHING;
        } else {
            if (strike > 0) {
                result += strike + STRING_STRIKE;
            }
            if (ball > 0) {
                result += (result.isEmpty() ? "" : " ") + ball + STRING_BALL;
            }
        }
        System.out.println(result);
    }

    private void handleQuitOrRestart(String input) {
        if (input.equals(INPUT_QUIT)) {
            quit = true;
        } else if (input.equals(INPUT_RESTART)) {
            initializeRandomNumber();
        } else {
            System.out.println("1 또는 2를 입력하세요.");
        }
    }
}
