package baseball.view;

import baseball.constants.MessageConstants;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public void printGameStartMessage(){
        System.out.println(MessageConstants.START_GAME_MESSAGE);
    }

    public void printUserInputGuideMessage(){
        System.out.print(MessageConstants.USER_INPUT_MESSAGE);
    }

    public void printGameOverMessage() {
        System.out.println(MessageConstants.END_GAME_MESSAGE);
    }

    public void printWhetherRestartOrExitMessage() {
        printGameOverMessage();
        System.out.println(MessageConstants.WHETHER_RESTART_OR_EXIT_MESSAGE);
    }

    public void printResultGameMessage(int ballCount, int strikeCount) {

        String message = "";

        if (ballCount != 0) {
            message = ballCount + MessageConstants.BALL_MESSAGE;
        }

        if (strikeCount != 0) {
            message += strikeCount + MessageConstants.STRIKE_MESSAGE;
        }

        if (ballCount == 0 && strikeCount == 0) {
            message = MessageConstants.FAIL_MESSAGE;
        }

        System.out.println(message);
    }

    public String getUserInput() {
        printUserInputGuideMessage();
        return Console.readLine();
    }

    public String getGameMenu() {
        return Console.readLine();
    }
}
