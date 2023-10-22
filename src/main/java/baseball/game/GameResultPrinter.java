package baseball.game;

public class GameResultPrinter {
    /**
     * 3 스트라이크 출력
     */
    public static void printAllStrike() {
        System.out.println("3스트라이크");
    }

    /**
     * 낫싱 출력
     */
    public static void printNothing() {
        System.out.println("낫싱");
    }

    /**
     * ?볼 ?스트라이크 출력
     */
    public static void printProceeding(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
}
