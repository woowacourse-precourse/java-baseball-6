package game;

public class Result {
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_THREE = 3;

    public static void printResult(int strike,int ball) {
        if (strike == COUNT_ZERO && ball == COUNT_ZERO) {
            printNothing();
            return;
        }
        if (strike == COUNT_THREE) {
            printEnd();
            return;
        }
        printBall(ball);
        printStrike(strike);
    }
    private static void printBall(int ball) {
        if(ball != COUNT_ZERO) {
            System.out.print(ball + "볼 ");
        }
    }
    private static void printStrike(int strike) {
        if(strike == COUNT_ZERO) {
            System.out.println("");
            return;
        }
        System.out.println(strike + "스트라이크");
    }
    private static void printNothing() {
        System.out.println("낫싱");
    }
    private static void printEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
