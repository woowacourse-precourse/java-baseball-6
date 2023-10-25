package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final String MESSAGE_GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String MESSAGE_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String MESSAGE_GAME_END_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String MESSAGE_WRONG_NUMBER = "올바른 수를 입력해 주세요";


    private static void checkUserGuessingNumberInput(String guessingNumber) {

        boolean isValid = false;
        if (a.length() != 3) {
            isValid = true;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < '1' || a.charAt(i) > '9') {
                isValid = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (a.charAt(i) == a.charAt(j)) {
                    isValid = true;
                }
            }
        }
        if (isValid) {
            throw new IllegalArgumentException("올바른 수를 입력해 주세요");
        }
    }

    private static String userGuessingNumberInput() {
        String guessingNumber = Console.readLine();
        checkUserGuessingNumberInput(guessingNumber);
        return guessingNumber;
    }

    private static void checkUserReplayInput(String replayNumber) {
    }

    private static String userReplayInput() {
        String replayNumber = Console.readLine();
        checkUserReplayInput(replayNumber);
        return replayNumber;

    }

    private static String generateRandomNumber() {
        StringBuffer sb = new StringBuffer();
        boolean[] vis = new boolean[10];
        while (true) {
            int rand = Randoms.pickNumberInRange(1, 9);
            if (vis[rand]) {
                continue;
            }
            sb.append(rand);
            if (sb.length() == 3) {
                break;
            }
            vis[rand] = true;
        }
        return sb.toString();
    }

    private static int calculateStrike(String randomNumber, String GuessingNumber) {

    }

    private static int calculateBall(String randomNumber, String GuessingNumber) {

    }

    private static void printResult(int strike, int ball) {
        if (ball > 0) {
            System.out.printf(ball + "볼");
            if (strike > 0) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    private static boolean userEndGameInput(int strike) {
        return userReplayInput().equals("2");
    }


    private static boolean play(String randomNumber, String guessingNumber) {
        boolean end = false;
        while (!end) {

            int strike = calculateStrike(randomNumber, guessingNumber);
            int ball = calculateBall(randomNumber, guessingNumber);

            printResult(strike, ball);
            end = userEndGameInput(strike);

        }
        return false;
    }


    public void start() {
        while (play(generateRandomNumber(), userGuessingNumberInput())) {
        }
    }

}


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.start();
    }
}
