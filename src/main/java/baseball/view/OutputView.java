package baseball.view;

import baseball.constants.BaseballRole;
import baseball.constants.message.ProgressMessage;

public class OutputView {

    public void printStartBaseBallGameMessage(){
        System.out.println(ProgressMessage.START_BASEBALL_GAME);
    }

    public void printInputExpectedNumberMessage(){
        System.out.println(ProgressMessage.INPUT_EXPECTED_NUMBER);
    }

    public void printStatusBallAndStrike(String message){
        System.out.println(message);
    }

    public void printClearBaseBallGame(){
        String message = String.format(ProgressMessage.CLEAR_BASEBALL_GAME.toString(), BaseballRole.THREE_STRIKE.getValue());
        System.out.println(message);
    }

    public void printRestartMessage(){
        String message = String.format(ProgressMessage.INPUT_RESTART_MESSAGE.toString(),
                BaseballRole.GAME_RESTART.getValue(), BaseballRole.GAME_EXIT.getValue());
        System.out.println(message);
    }
}
