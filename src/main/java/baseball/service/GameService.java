package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameResultDTO;

public class GameService {
    private GameNumber computerNumber;

    public void setComputerNumber() {
        computerNumber = new GameNumber();
    }

    public GameResultDTO calculateGameResult(GameNumber playerNumber) {

        GameResultDTO gameResultDTO = new GameResultDTO(computerNumber, playerNumber);

        return gameResultDTO;
    }
}