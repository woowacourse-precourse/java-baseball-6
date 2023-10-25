package baseball;

import org.w3c.dom.Text;

public class output {

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

    public void threeStrike(int strike) {
        text text = new text();
        if (strike == 3) {
            text.win();
        }
    }
}
