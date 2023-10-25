package util;

import game.BallCount;

public class GamePrinter {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";


    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void resultBallCount(BallCount ballCount) {
        int ball = ballCount.getBalls();
        int strike = ballCount.getStrikes();

        if (isZero(ball) && isZero(strike)) {
            System.out.println(NOTHING);
        }

        if (isZero(ball) && !isZero(strike)) {
            System.out.println(strike + STRIKE);
        }

        if (isZero(strike) && !isZero(ball)) {
            System.out.println(ball + BALL);
        }

        if (!isZero(ball) && !isZero(strike)) {
            System.out.println(ball + BALL + SPACE + strike + STRIKE);
        }
    }

    public static void isAnswer(int strikeAnswer) {
        System.out.println(strikeAnswer + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void restartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean isZero(int size) {
        if (size == 0) {
            return true;
        }
        return false;
    }


}
