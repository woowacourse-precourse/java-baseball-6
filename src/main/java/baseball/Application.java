package baseball;

import baseball.game.BaseballGameMachine;

public class Application {

    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        baseballGameMachine.start();
    }
}
