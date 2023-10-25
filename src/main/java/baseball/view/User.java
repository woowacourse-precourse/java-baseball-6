package baseball.view;

import static baseball.util.MessageConstants.GAME_CHOICE_MESSAGE;
import static baseball.util.MessageConstants.STARTING_MESSAGE;
import static baseball.util.MessageConstants.USER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public void showStartMessage() {
        System.out.println(STARTING_MESSAGE.getContent());
    }

    public String getUserInput() {
        System.out.print(USER_INPUT_MESSAGE.getContent());
        return Console.readLine();
    }

    public String getGameChoiceInput() {
        System.out.println(GAME_CHOICE_MESSAGE.getContent());
        return Console.readLine();
    }
}
