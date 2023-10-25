package baseball;

public class Output {

    public void ballPrint(int ball) {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
    }

    public void strikePrint(int strike) {
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
    }

    public void scorePrint(int ball, int strike) {
        if (ball > 0 || strike > 0) {
            ballPrint(ball);
            strikePrint(strike);
        } else {
            System.out.print("낫싱");
        }
    }
}
