package baseball.service;

import baseball.dto.GameCommand;
import baseball.util.GameNumberGenerator;
import baseball.util.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.Constants.GAME_RESTART_INPUT;
import static baseball.constants.Constants.GAME_START_STRING;
import static baseball.dto.GameCommand.RESTART;

public class GameRunner {
    private final NumberGenerator numberGenerator;

    public GameRunner() {
        numberGenerator = new GameNumberGenerator();
    }

    public void start() {
        System.out.println(GAME_START_STRING);
        do {
            new Game(numberGenerator).playGame();
            System.out.println(GAME_RESTART_INPUT);
        } while (isReplay(Console.readLine()));
    }

    public boolean isReplay(String input) {
        GameCommand gameCommand = GameCommand.fromInputCommand(input);
        return gameCommand == RESTART;
    }

}
