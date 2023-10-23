package baseball.service;

import baseball.domain.Command;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.RoundResult;

public class BaseballService {
    private final Player player;
    private final Computer computer;

    public BaseballService(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void startNewGame() {
        computer.generateAnswerNumbers();
    }

    public RoundResult playRoundWithGuess(String guessedNumbers) {
        player.guessNumbers(guessedNumbers);
        return calculateRoundResult();
    }

    public boolean isRetry(String command) {
        return Command.fromValue(command) == Command.RETRY;
    }

    private RoundResult calculateRoundResult() {
        return RoundResult.of(player.getGuessedNumbers(), computer.getAnswerNumbers());
    }
}
