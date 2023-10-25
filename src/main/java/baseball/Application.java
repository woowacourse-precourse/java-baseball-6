package baseball;

import baseball.domain.Computer;

public class Application {
    public static void main(String[] args) {
        boolean isFirstGame = true;
        new Computer().startGame(isFirstGame);
    }
}
