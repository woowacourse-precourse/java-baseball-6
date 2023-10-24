package baseball.view;

import org.w3c.dom.ls.LSOutput;

public class MainView {
    public void displayResult(int strike, int ball, int nothing) {
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (nothing > 0) {
            System.out.print( "낫싱 ");
        }
        System.out.println();
    }
}
