package baseball;

import baseball.api.GameHelper;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        GameHelper gameHelper = new GameHelper();
        gameHelper.startGame().run().retryGame();
    }
}
