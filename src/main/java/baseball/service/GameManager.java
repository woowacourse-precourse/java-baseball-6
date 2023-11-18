package baseball.service;

import baseball.dto.RoundResultDto;
import baseball.model.ComputerNumber;
import baseball.model.RoundResult;
import baseball.model.UserNumber;

public class GameManager {
    private final ComputerNumber computerNumber;
    private RoundResult roundResult;

    private GameManager(ComputerNumber computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static GameManager from(ComputerNumber computerNumber) {
        return new GameManager(computerNumber);
    }

    public boolean playRound(UserNumber userNumber) {
        roundResult = RoundResult.create(computerNumber, userNumber);
        return roundResult.needsNextRound();
    }

    public RoundResultDto createResultDto() {
        return RoundResultDto.from(roundResult);
    }
}