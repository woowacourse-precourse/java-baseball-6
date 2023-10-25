package baseball.my_io;

public class MyOutput {
    /*
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    prvate static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
     */

    public static void printGameResult(int strike, int ball) {
        printStrikeAndBall(strike, ball);
        printOnlyStrike(strike, ball);
        printOnlyBall(strike, ball);
        printNothing(strike, ball);
        printGameEnd(strike, ball);
    }

    private static void printStrikeAndBall(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static void printOnlyStrike(int strike, int ball) {
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    private static void printOnlyBall(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
    }

    private static void printNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    private static void printGameEnd(int strike, int ball) {
        if (strike == 3 && ball == 0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
