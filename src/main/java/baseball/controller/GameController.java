package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameLogic;
import baseball.view.GameIO;
import java.util.List;
import java.util.Map;

public class GameController {
    private final GameIO gameIO;
    private final GameLogic gameLogic;

    public GameController(GameIO gameIO, GameLogic gameLogic) {
        this.gameIO = gameIO;
        this.gameLogic = gameLogic;
    }
    /**
     * 게임 시작 문구 출력
     */
    public void init() {
        gameIO.printStartGameMessage();
    }

    /**
     * 게임 진행 메서드
     */
    public void runGame() {
        boolean continueRequested;

        do {
            Computer computer = new Computer();
            List<Integer> computerNumbers = computer.createRandomNumber();

            Map compareResult;
            do {
                String playerGuess = gameIO.readPlayerGuess();

                List<Integer> playerGuessNumbers = gameLogic.validateAndReturnBaseBallNumber(playerGuess);

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
