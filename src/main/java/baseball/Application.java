package baseball;

import baseball.play.GameMachine;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.play();
    }
}