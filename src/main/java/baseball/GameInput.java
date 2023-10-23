package baseball;


import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    private final String input;

    public GameInput() {
        this.input = receiveUserInput();
    }

    private String receiveUserInput() {
        return Console.readLine();
    }
}
