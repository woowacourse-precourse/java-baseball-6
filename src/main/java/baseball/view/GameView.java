package baseball.view;

import static baseball.domain.Constants.START_GAME_MESSAGE;
import static baseball.domain.Constants.USER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void startGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public String getUserInput() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }
}
