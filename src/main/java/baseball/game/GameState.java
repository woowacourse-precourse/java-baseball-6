package baseball.game;

import baseball.PrintMessage;
import baseball.Rule;
import camp.nextstep.edu.missionutils.Console;

public class GameState implements Rule {
    int state;

    void gameStart() {
        PrintMessage.start();
        state = STATE_PLAY;
    }

    boolean isPlaying() {
        return (state == STATE_PLAY);
    }

    void askRegame() {
        PrintMessage.regame();
        String input = Console.readLine();
        validateInput(input);
    }

    private void validateInput(String input) {
        int inputState = Integer.parseInt(input);
        if (inputState == STATE_PLAY) {
            state = STATE_PLAY;
            return;
        }
        if (inputState == STATE_TERMINATE) {
            state = STATE_TERMINATE;
            return;
        }
        throw new IllegalArgumentException();
    }

}
