package baseball.view;

import static baseball.util.Constants.*;

import java.util.ArrayList;
import baseball.util.Messages;

public class OutputView {
    public void printStart() {
        System.out.println(Messages.START_GAME);
    }

    public void printEndGame() {
        System.out.println(Messages.END_GAME);
    }

    public void printInputNum() {
        System.out.print(Messages.INPUT);
    }

    public void printResult(ArrayList<Integer> ballStrikeCount) {
        int ballCount = ballStrikeCount.get(ZERO);
        int strikeCount = ballStrikeCount.get(ONE);

        if (strikeCount == ZERO && ballCount == ZERO) {
            System.out.print(Messages.NOTHING);
        }
        if (ballCount > ZERO) {
            System.out.print(ballCount + Messages.BALL);
        }
        if (strikeCount > ZERO) {
            System.out.print(strikeCount + Messages.STRIKE);
        }
        System.out.println();
    }
}
