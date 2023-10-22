package baseball.service;

import baseball.dto.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.Constants.GAME_START_STRING;
import static baseball.dto.GameCommand.RESTART;

public class GameRunner {

    public void start() {

        System.out.println(GAME_START_STRING);
        do {
            Game game = new Game();
            game.playGame();
        } while (isReplay(Console.readLine()));
    }

    public boolean isReplay(String input) {
        GameCommand gameCommand = GameCommand.fromInputCommand(input);
        return gameCommand == RESTART;
    }

}
