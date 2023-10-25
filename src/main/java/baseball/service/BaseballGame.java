package baseball.service;

import baseball.model.GameRestartState;
import baseball.util.ErrorMessage;
import baseball.util.OutputUtils;
import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.util.ExceptionHandler.triggerException;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private static final int VICTORY_CONDITION_STRIKE_COUNT = 3;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void playGame() {
        do {
            OutputUtils.printGameStartMessage();
            progressGame();
        } while (askRestartGame());
    }

    public void progressGame() {
        computer.setNumbers(computer.generateRandomNumbers());
        do {
            player.retrievePlayerNumber();
        } while (!isPlayerHit());

        OutputUtils.printGameSetMessage();
    }

    public int countStrikes(List<Integer> computerNums, List<Integer> playerNums) {
        // i번째 위치가 일치하는 경우
        return (int) IntStream.range(0, computerNums.size())
                .filter(i -> computerNums.get(i)
                        .equals(playerNums.get(i)))
                .count();
    }

    public int countBalls(List<Integer> computerNums, List<Integer> playerNums) {
        // i번째 위치에서 일치하지 않고, 다른 위치에 포함하는 경우
        return (int) IntStream.range(0, computerNums.size())
                .filter(i -> (!playerNums.get(i)
                        .equals(computerNums.get(i)))
                        && (playerNums
                        .contains(computerNums.get(i))))
                .count();
    }

    public boolean isPlayerHit() {
        int strikeCount = this.countStrikes(computer.getNumbers(), player.getNumbers());
        int ballCount = this.countBalls(computer.getNumbers(), player.getNumbers());

        OutputUtils.printCurrentResult(strikeCount, ballCount);
        return strikeCount == VICTORY_CONDITION_STRIKE_COUNT;
    }

    public boolean askRestartGame() {
        GameRestartState restartFlag = player.retrieveRestartNumber();

        if (restartFlag == GameRestartState.UNKNOWN) {
            triggerException(ErrorMessage.INVALID_RESTART_INPUT);
        }
        return restartFlag == GameRestartState.RESTART;
    }
}
