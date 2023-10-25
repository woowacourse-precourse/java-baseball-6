package baseball;

import constant.Constant;
import constant.GameMessage;
import utils.InputUtil;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        boolean willBeRestarted = true;

        do {
            baseballGame.startGame();
            willBeRestarted = checkRestart();
        } while (willBeRestarted);
    }

    private static boolean checkRestart() {
        System.out.println(GameMessage.RESTART_INPUT_MESSAGE.getMessage());

        Integer restartInfo = InputUtil.getRestartInfo();

        return checkIfRestart(restartInfo);
    }

    private static boolean checkIfRestart(int restartInfo) {
        if (restartInfo == Constant.RESTART_VALUE.getValue()) {
            return true;
        }
        return false;
    }
}
