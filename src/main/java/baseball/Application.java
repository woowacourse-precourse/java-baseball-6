package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GamePlay gamePlay = new GamePlay();
        gamePlay.playGame();
    }
}

class GamePlay {
    private int[] randomNumber = generateRandomNumber();
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameState = false;

        while (!gameState) {
            System.out.print("숫자를 입력하세요 : ");
            try {
                if (scanner.hasNextInt()) {
                    String distinguishZero = scanner.next();
                    if (distinguishZero.length() != 3 || distinguishZero.charAt(0) == '0' || !distinguishZero.matches("\\d+")) {
                        throw new IllegalArgumentException("올바른 범위의 3자리 숫자를 입력하세요.");
                    }

                    int userNum = Integer.parseInt(distinguishZero);
                    int[] userNumArray = numberToArray(userNum);
                    int strikes = countStrikes(randomNumber, userNumArray);
                    int balls = countBalls(randomNumber, userNumArray);

                    if (strikes == 0 && balls == 0) {
                        System.out.println("낫싱");
                    } else if (strikes == 0) {
                        System.out.println(balls + "볼");
                    } else if (balls == 0) {
                        System.out.println(strikes + "스크라이크");
                    } else {
                        System.out.println(balls + "볼 " + strikes + "스크라이크");
                    }
                    if (strikes == 3) {
                        System.out.println("3 스트라이크 " +
                                "3개의 숫자를 모두 맞추셨습니다! 게임 종료" +
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int number = scanner.nextInt();
                        if (number == 1) {
                            randomNumber = generateRandomNumber();
                        } else {
                            gameState = true;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("문자가 아닌 정수를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("오류 : " + e.getMessage());
                break;
            }
        }
        scanner.close();
    }

    public static int[] generateRandomNumber() {
        Random random = new Random();
        int[] randomNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            int number;
            do {
                number = random.nextInt(9) + 1;
            } while (containsNumber(randomNumber, number));
            randomNumber[i] = number;
        }
        return randomNumber;
    }

    //중복 비교
    public static boolean containsNumber(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    // 정수를 배열로 변환
    public static int[] numberToArray(int number) {
        int[] array = new int[3];

        for (int i = 2; i >= 0; i--) {
            array[i] = number % 10;
            number /= 10;
        }

        return array;
    }

    // 스트라이크 수 계산
    public static int countStrikes(int[] randomNumber, int[] userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber[i] == userNumber[i]) {
                strikes++;
            }
        }
        return strikes;
    }

    // 볼 수 계산
    public static int countBalls(int[] randomNumber, int[] userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber[i] != userNumber[i] && containsNumber(randomNumber, userNumber[i])) {
                balls++;
            }
        }
        return balls;
    }

}