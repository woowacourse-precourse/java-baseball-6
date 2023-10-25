package baseball;

public class Printer {
    static public void baseball(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            Printer.nothing();
        } else if (ball >= 1 && strike >= 1) {
            Printer.all(strike, ball);
        } else if (ball >= 1) {
            Printer.ball(ball);
        } else if (strike >= 1) {
            Printer.strike(strike);
        }
    }

    static private void nothing() {
        System.out.println("낫싱");
    }

    static private void all(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    static private void ball(int ball) {
        System.out.println(ball + "볼");
    }

    static private void strike(int strike) {
        System.out.println(strike + "스트라이크");
    }
}
