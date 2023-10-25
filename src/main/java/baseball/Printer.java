package baseball;

public class Printer {

    public static void print(String message) {
        System.out.print(message);
    }
    public static void println() {
        System.out.println();
    }
    public static void println(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        printNotThing(result);
        printBall(ball);
        printStrike(strike);
    }

    private static void printNotThing(Result result) {
        if (result.ball() == 0 && result.strike() == 0) {
            println("낫싱");
        }
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            print(ball + "볼 ");
        }
    }
    private static void printStrike(int strike) {
        if (strike > 0) {
            print(strike + "스트라이크");
        }
        println();
    }
}
