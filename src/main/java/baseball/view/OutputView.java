package baseball.view;

import static baseball.util.Constants.ZERO;
import static baseball.util.Constants.ONE;

import baseball.util.Messages;
import java.util.ArrayList;


public class OutputView {
    public void printStart() {
        System.out.println(Messages.START_GAME);
    }

    public void printEndGame() {
        System.out.println(Messages.END_GAME);
    }

    public void printNoting() {
        System.out.println(Messages.NOTHING);
    }

    public void printInputNum() {
        System.out.print(Messages.INPUT);
    }

    public void printResult(ArrayList<Integer> ballStrikeCount) {
        int ballCount = ballStrikeCount.get(ZERO);
        int strikeCount = ballStrikeCount.get(ONE);

        if (strikeCount == ZERO && ballCount == ZERO) {
            System.out.println(Messages.NOTHING);
        }
        if (ballCount > ZERO) {
            System.out.print(ballCount + Messages.BALL);
        }
        if (strikeCount > ZERO) {
            System.out.println(strikeCount + Messages.STRIKE);
        }
    }
}
