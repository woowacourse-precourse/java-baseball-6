package baseball.view;

import static baseball.constant.Constant.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class GameView {
    public String getPlayerGuess() {
        System.out.print(GUESS_NUMBER_MESSAGE);
        return readLine();
    }

    public void displayStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
