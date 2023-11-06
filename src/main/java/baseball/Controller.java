package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.GameService;

import java.util.ArrayList;

public class Controller {

    private static final GameService gameService = new GameService();
//    public static AppConfig appConfig;

    public static void playGame() {
        Computer computer = gameService.initComputer();   // retrieve Model

        while (true) {
            // +
            Player player = gameService.initPlayer();

            ArrayList<Integer> result = gameService.getResult(computer, player);
            gameService.showResult(result);
            // = gameService.playGame(computer);

            if (result.get(1) != 3) continue;

            if (!gameService.confirmGameRestart()) break;
            computer = gameService.setComputer();
        }

    }


}
