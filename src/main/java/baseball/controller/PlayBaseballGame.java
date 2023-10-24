package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ComputerService;
import baseball.service.PlayerService;

public class PlayBaseballGame {
    private final ComputerService computer = new ComputerService();
    private final PlayerService player = new PlayerService();
    private final Computer computerNumber = new Computer();
    private final Player playerNumber = new Player();

    public void play() {
        computerNumber.setComputerNumber(computer.createRandomNumber());

        boolean isReplay = true;
        while (isReplay) {
            playerNumber.setPlayerNumber(player.inputPlayerNumber());

        }
    }
}
