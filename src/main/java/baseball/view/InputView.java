package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        return Console.readLine();
    }

    public void playerNumber() {
        System.out.println(InputMessage.INPUT_PLAYER_NUMBER);
    }

    public void restartGame() {
        System.out.println(InputMessage.INPUT_RESTART_COMMAND);
    }
}
