package baseball.controller;


import static baseball.utils.OutputMessage.introMessage;

import baseball.domain.Computer;
import baseball.domain.NumberBaseballGame;
import baseball.domain.Player;

public class GameController {

    public static void initNumberBaseballGame() {
        introMessage();
        initGame();
    }

    private static void initGame() {
        Player player = new Player();
        Computer computer = new Computer();
        NumberBaseballGame game = new NumberBaseballGame(player, computer);
        game.gameStart();
    }

    public static void restartGame(String request) {
        if ("1".equals(request)) {
            initGame();
        }
    }

}
