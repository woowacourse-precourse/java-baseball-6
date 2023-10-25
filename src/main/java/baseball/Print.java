package baseball;

public class Print {
    static public void baseball(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            Print.nothing();
        } else if (ball >= 1 && strike >= 1) {
            Print.all(strike, ball);
        } else if (ball >= 1) {
            Print.ball(ball);
        } else if (strike >= 1) {
            Print.strike(strike);
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
