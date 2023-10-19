package baseball.controller;

import baseball.domain.ComputerNumber;

public class GameMachine {

    private final ComputerNumber computerNumber;

    public GameMachine(ComputerNumber computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void start() {
        computerNumber.createComputerNumbers();

    }
}
