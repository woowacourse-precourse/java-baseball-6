package baseball.view;

import baseball.constant.GameMessage;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public void printGameStart() {
        System.out.println(GameMessage.START.getMessage());
    }

    public Boolean restart() {
        System.out.println(GameMessage.ASK_RESTART.getMessage());
        String input = Console.readLine();

        InputValidator.validateRestartNumber(input);

        if (input.equals("1")) {
            return true;
        }

        return false;
    }
}