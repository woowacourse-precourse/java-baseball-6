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

    public void displaySuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public void displayResultMessage(String result) {
        System.out.println(result);
    }

    public int restartCheck() {
        System.out.println(RESTART_MESSAGE);
        return Integer.parseInt(readLine());
    }
}