package baseball.view;

import baseball.constants.Constants;
import baseball.model.ComputerNumber;
import org.w3c.dom.ls.LSOutput;

public class MainView {
    public void displayResult(int strike, int ball, int nothing) {
        if (strike > 0) {
            System.out.print(strike + Constants.STRIKE);
        }
        if (ball > 0) {
            System.out.print(ball + Constants.BALL);
        }
        if (nothing > 0) {
            System.out.print( Constants.NOTHING);
        }
        System.out.println();
    }
}
