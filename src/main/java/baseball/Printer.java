package baseball;

public class Printer {
    static public void printBaseballCount(int strike, int ball) {
        if (isNothing(strike, ball)) {
            Printer.printNothing();
        } else if (isAll(strike, ball)) {
            Printer.printAll(strike, ball);
        } else if (isBall(ball)) {
            Printer.printBall(ball);
        } else if (isStrike(strike)) {
            Printer.printStrike(strike);
        }
    }

    static private boolean isNothing(int strike, int ball) {
        return (strike == 0 && ball == 0);
    }

    static private boolean isAll(int strike, int ball) {
        return (ball >= 1 && strike >= 1);
    }

    static private boolean isBall(int ball) {
        return (ball >= 1);
    }

    static private boolean isStrike(int strike) {
        return (strike >= 1);
    }

    static private void printNothing() {
        System.out.println("낫싱");
    }

    static private void printAll(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    static private void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    static private void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }
}
