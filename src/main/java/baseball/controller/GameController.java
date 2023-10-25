package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.GameLogic;
import baseball.view.GameIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {
    private final GameIO gameIO;
    private final GameLogic gameLogic;

    public GameController(GameIO gameIO, GameLogic gameLogic) {
        this.gameIO = gameIO;
        this.gameLogic = gameLogic;
    }
    public void init() {
        gameIO.printStartGameMessage();
    }
    public void runGame() {
        boolean continueRequested;

        do {
            Computer computer = new Computer();
            List<Integer> computerNumbers = new ArrayList<>();
            computerNumbers = computer.createRandomNumber();

            Map compareResult = new HashMap<>();
            do {
                GameLogic gameLogic = new GameLogic();
                String playerGuess = gameIO.readPlayerGuess();

                List<Integer> playerGuessNumbers = new ArrayList<>();
                playerGuessNumbers = gameLogic.validateAndReturnBaseBallNumber(playerGuess);

                compareResult = gameLogic.compareNumbers(playerGuessNumbers, computerNumbers);
                gameIO.printBallStrike(compareResult);

            } while (!isPlayerGameComplete(compareResult));

            continueRequested = gameIO.askPlayerToContinue();
        } while (continueRequested);

    }

    public boolean isPlayerGameComplete(Map<String, Integer> compareResult){
        return compareResult.get("strike") == 3;
    }
}
