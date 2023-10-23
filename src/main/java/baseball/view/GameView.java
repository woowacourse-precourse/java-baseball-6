package baseball.view;

import static baseball.domain.Constants.END_GAME_MESSAGE;
import static baseball.domain.Constants.RESTART_GAME_MESSAGE;
import static baseball.domain.Constants.START_GAME_MESSAGE;
import static baseball.domain.Constants.USER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void startGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public String getUserInput() {
        System.out.print(USER_INPUT_MESSAGE);

        String userInput = Console.readLine();

        return userInput;
    }

    public void printHintMessage(String hintMessage) {
        System.out.println(hintMessage);
    }

    public int endGame() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RESTART_GAME_MESSAGE);

        String userInput = Console.readLine();
        int restartType = Integer.parseInt(userInput);

        return restartType;
    }
}
