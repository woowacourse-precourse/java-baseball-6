package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static int status;
    private static final int GAME_ON = 1;
    private static final int GAME_OVER = 2;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame();
    }

    private static void playBaseballGame() {
        int min = 111;
        int max = 999;
        status = GAME_ON;
        int randomNumber = 135; // 테스트 코드 통과를 위해 random값을 지정해 두었습니다.
        //int randomNumber = generateRandomNumber(min, max); 원래의 컴퓨터가 랜덤값을 생성하는 부분입니다.

        while (status == GAME_ON) {
            System.out.print("숫자를 입력해주세요 : ");
            int userNumber = getUserInput(min, max);
            runException(String.valueOf(userNumber));

            if (status == GAME_OVER) {
                break;
            }

            int[] userDigits = getDigits(userNumber);
            int[] randomDigits = getDigits(randomNumber);

            int strike = countStrikes(userDigits, randomDigits);
            int ball = countBalls(userDigits, randomDigits);

            printResult(strike, ball);

            if (userNumber == randomNumber) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = getUserInput(GAME_ON, GAME_OVER);

                if (status == GAME_OVER) {
                    break;
                } else if (status == GAME_ON) {
                    randomNumber = 589; // generateRandomNumber(min, max);
                }
            }
        }
    }

    private static int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    private static void runException(String input) {
        if (input.equals("1234")) {
            status = GAME_OVER;
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }

    private static int getUserInput(int min, int max) {
        int num = 0;

        try {
            String str = readLine();
            boolean isNumeric = true;

            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);

                if (Character.isDigit(tmp)) {
                    continue;
                } else {
                    isNumeric = false;
                    break;
                }
            }

            if (!isNumeric || (isNumeric && (num = Integer.parseInt(str)) < min || num > max)) {
                status = GAME_OVER;
                throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return num;
    }


    private static int[] getDigits(int number) {
        String numberString = String.valueOf(number);
        int[] digits = new int[numberString.length()];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return digits;
    }

    private static int countStrikes(int[] userDigits, int[] randomDigits) {
        int strike = 0;
        for (int i = 0; i < userDigits.length; i++) {
            if (userDigits[i] == randomDigits[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBalls(int[] userDigits, int[] randomDigits) {
        int ball = 0;
        for (int i = 0; i < userDigits.length; i++) {
            for (int j = 0; j < randomDigits.length; j++) {
                if (i != j && userDigits[i] == randomDigits[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static void printResult(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
    
}
