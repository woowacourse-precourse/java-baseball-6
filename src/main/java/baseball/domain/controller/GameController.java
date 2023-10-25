package baseball.domain.controller;

import baseball.domain.model.Computer;

import java.util.List;

public class GameController {
    private final Computer computer;

    public GameController(List<String> computerBalls) {
        this.computer = new Computer(computerBalls);
    }
}
