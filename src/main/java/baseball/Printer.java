package baseball;

public class Printer {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void printRoundResult(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        printBall(ball);
        printStrike(strike);
        printNotThing(result);
    }

    private static void printNotThing(Result result) {
        if (result.ball() == 0 && result.strike() == 0) {
            System.out.println("낫싱");
        }
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
    }
    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
    }
}
