package baseball.utils;

public class Printer {
    public static void printGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }
}
