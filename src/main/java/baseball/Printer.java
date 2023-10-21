package baseball;

public class Printer {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printHint(Hint hint) {
        int ball = hint.getBall();
        int strike = hint.getStrike();
        if ((ball != 0) && (strike != 0)) {
            printBallAndStrike(ball, strike);
        }
        if ((ball != 0) && (strike == 0)) {
            printBall(ball);
        }
        if ((ball == 0) && (strike != 0)) {
            printStrike(strike);
        }
        if ((ball == 0) && (strike == 0)) {
            printNothing();
        }
    }

    public static void printGameWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGameRestartOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void printBallAndStrike(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private static void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    private static void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    private static void printNothing() {
        System.out.println("낫싱");
    }
}
