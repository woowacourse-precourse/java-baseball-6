package baseball;

import baseball.handler.UserInputHandler;

public class Game {
    private final UserInputHandler userInputHandler = new UserInputHandler();

    public void play() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public boolean checkRestart() {
        return userInputHandler.askRestart();
    }
}
