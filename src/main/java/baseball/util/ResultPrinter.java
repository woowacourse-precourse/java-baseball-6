package baseball.util;

public class ResultPrinter {
    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
    }
}
