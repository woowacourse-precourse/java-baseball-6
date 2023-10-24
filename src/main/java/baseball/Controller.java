package baseball;

import static baseball.Constant.RESTART_MESSAGE;
import static baseball.Constant.RESTART_STRING;
import static baseball.Constant.TERMINATE_STRING;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public Controller() {
    }

    public void start() {
        do {
            Game game = new Game();
            game.play();
        } while (restart());
    }

    private static boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if (inputString.equals(RESTART_STRING)) {
            return true;
        } else if (inputString.equals(TERMINATE_STRING)) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}