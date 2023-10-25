package baseball.global;

import baseball.controller.GameController;
import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerNumbers;
import baseball.service.GameService;

public class Config {
    public PlayerNumbers playerNumber() {
        return new PlayerNumbers();
    }

    public Player player() {
        return new Player(playerNumber());
    }
    public Game game() {
        return new Game(player());
    }
    public GameService gameService() {
        return new GameService(game());
    }
    public GameController gameController() {
        return new GameController(gameService());
    }
}
