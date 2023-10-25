package baseball;

import baseball.controller.GameController;
import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerNumbers;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlayerNumbers playerNumbers = new PlayerNumbers();
        Player player = new Player(playerNumbers);
        Computer computer = new Computer();
        Game game = new Game(computer, player);
        GameService gameService = new GameService(player, computer, game);

        GameController gameController = new GameController(gameService);
        gameController.run();


    }
}
