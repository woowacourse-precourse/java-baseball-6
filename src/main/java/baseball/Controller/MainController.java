package baseball.Controller;

import baseball.View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class MainController {
    GameController gameController;

    public MainController() {
        gameController = new GameController();
    }

    public void startProgram() {
        boolean whetherRestart = false;
        do {
            gameController.startGame();
            whetherRestart = InputController.scanWhetherRestart();
        } while(whetherRestart);
    }

    private static class InputController {
        private static final String WRONG_INPUT_WHETHER_RESTART_MESSAGE = "1 또는 2를 입력해주세요.";
        private static final char RESTART = '1';
        private static final char END_GAME = '2';

        public static boolean scanWhetherRestart() {
            InputView.printEnterWhetherRestart();
            String inp = Console.readLine();
            validateWhetherRestart(inp);
            return false;
        }

        private static void validateWhetherRestart(String inp) {
            if (inp.length() != 1) throw new IllegalArgumentException(WRONG_INPUT_WHETHER_RESTART_MESSAGE);
            else if (inp.charAt(0) != RESTART || inp.charAt(0) != END_GAME)
                throw new IllegalArgumentException(WRONG_INPUT_WHETHER_RESTART_MESSAGE);
        }
    }
}
