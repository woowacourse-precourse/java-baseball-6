package baseball.controller;

import baseball.domain.Ball;
import baseball.service.Computer;

public class PlayBaseballGame {
    private final Computer computer = new Computer();
    private Ball computerNumber;

    public void play() {
        computerNumber = computer.createRandomNumber();
    }

}
