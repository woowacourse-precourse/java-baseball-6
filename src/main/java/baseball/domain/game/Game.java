package baseball.domain.game;

import static baseball.domain.script.Script.GAME_START;

import baseball.domain.computer.ComputerService;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerService;

public class Game {
    private final ComputerService computerService;
    private final PlayerService playerService;

    public Game(ComputerService computerService, PlayerService playerService) {
        this.computerService = computerService;
        this.playerService = playerService;
    }

    public void play() {
        System.out.println(GAME_START.getMessage());
        computerService.generateRandomNumbers();

        while (true) {
            Player player = playerService.getPlayerInput();
            boolean result = computerService.compare(player);
            if (result) {
                if (playerService.getPlayerEnd()) {
                    break;
                }
                computerService.resetNumbers();
            }
        }
    }
}
