package baseball.controller;

import baseball.domain.Ball;
import baseball.service.Computer;
import baseball.service.Player;

public class PlayBaseballGame {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private Ball computerNumber;

    public void play() {
        computerNumber = computer.createRandomNumber();
        boolean isReplay = true;
        while (isReplay) {
            String playNumber = player.inputPlayerNumber();
        }
    }

}
