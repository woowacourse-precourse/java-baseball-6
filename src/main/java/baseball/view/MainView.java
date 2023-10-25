package baseball.view;

import baseball.constants.Constants;
import baseball.model.ComputerNumber;
import org.w3c.dom.ls.LSOutput;

public class MainView {
    EndView endView=new EndView();
    public void displayResult(int strike, int ball, int nothing) {
        if (ball > 0) {
            System.out.print(ball + Constants.BALL+" ");
        }
        if (strike > 0) {
            if(strike != 3) {
                System.out.print(strike + Constants.STRIKE+" ");
            } else {
                System.out.println(strike + Constants.STRIKE+" ");
                endView.displayEndMessage();
            }
        }

        if (nothing > 0) {
            System.out.print(Constants.NOTHING);
        }
        System.out.println();
    }
}
