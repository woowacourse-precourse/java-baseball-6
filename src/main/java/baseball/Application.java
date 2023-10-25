package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Game {

    private static final String MESSAGE_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String MESSAGE_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_GAME_END_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private static void checkUserGuessingNumberInput(String guessingNumber) {
        try {
            Exception e = new Exception();
            if (guessingNumber.length() != 3) {
                throw e;
            }
            for (int i = 0; i < guessingNumber.length(); i++) {
                if (guessingNumber.charAt(i) < '1' || guessingNumber.charAt(i) > '9') {
                    throw e;
                }
            }
            if (guessingNumber.charAt(0) == guessingNumber.charAt(1)) {
                throw e;
            }
            if (guessingNumber.charAt(0) == guessingNumber.charAt(2)) {
                throw e;
            }
            if (guessingNumber.charAt(1) == guessingNumber.charAt(2)) {
                throw e;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkUserOneOrTwoInput(String OneOrTwo) {
        try {
            Exception e = new Exception();
            if (OneOrTwo.equals("1") || OneOrTwo.equals("2")) {
                return;
            }
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    private static String userGuessingNumberInput() {
        String guessingNumber = Console.readLine();
        checkUserGuessingNumberInput(guessingNumber);
        return guessingNumber;
    }


    private static String userOneOrTwoInput() {
        String OneOrTwo = Console.readLine();
        checkUserOneOrTwoInput(OneOrTwo);
        return OneOrTwo;

    }

    private static String generateRandomNumber() {
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            ret.append(temp.get(i));
        }
        return ret.toString();
    }

    private static int calculateStrike(String randomNumber, String guessingNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == guessingNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private static int calculateBall(String randomNumber, String GuessingNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (randomNumber.charAt(i) == GuessingNumber.charAt(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static void printResult(int strike, int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼");
            if (strike > 0) {
                System.out.print(" ");
            }
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private static boolean endGame() {
        System.out.println(MESSAGE_GAME_END);
        System.out.println(MESSAGE_GAME_END_ASK);
        return userOneOrTwoInput().equals("1");
    }


    private static boolean play() {
        System.out.println(MESSAGE_GAME_START);
        String randomNumber = generateRandomNumber();

        while (true) {
            System.out.println(MESSAGE_ENTER_NUMBER);
            String guessingNumber = userGuessingNumberInput();
//            System.out.println(randomNumber + " " + guessingNumber);
            int strike = calculateStrike(randomNumber, guessingNumber);
            int ball = calculateBall(randomNumber, guessingNumber);

            printResult(strike, ball);
            if (strike == 3) {
                break;
            }

        }

        return endGame();
    }


    static void start() {
        while (play()) {
        }
    }

}

public class Application {
    public static void main(String[] args) {
        Game.start();
    }
}
