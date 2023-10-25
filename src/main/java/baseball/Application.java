package baseball;

import baseball.controller.GameController;
import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerNumbers;
import baseball.global.Config;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Config config = new Config();
            config.gameController().run();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }


    }
}
