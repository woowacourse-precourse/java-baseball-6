package baseball;

import baseball.controller.GameMachine;
import baseball.domain.ComputerNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMachine gameMachine = new GameMachine(new ComputerNumber());
        gameMachine.start();
    }
}
