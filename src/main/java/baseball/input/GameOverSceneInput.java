package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class GameOverSceneInput {
    public GameOverSceneInput() {
        // Empty
    }

    public String getUserInput() {
        final String userInput = Console.readLine();
        return userInput;
    }
}
