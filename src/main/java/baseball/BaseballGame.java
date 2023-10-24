package baseball;

import static baseball.Constant.END_MESSAGE;
import static baseball.Constant.EXIT;
import static baseball.Constant.INPUT_NUMBERS_MESSAGE;
import static baseball.Constant.INPUT_RETRY_EXIT_MESSAGE;
import static baseball.Constant.INVALID_CHOICE_MESSAGE;
import static baseball.Constant.RETRY;
import static baseball.Constant.START_MESSAGE;

import java.util.Objects;

public class BaseballGame {
    private final PlayerView playerView = new PlayerView();
    private GameResult gameResult;
    private Computer computer;
    private Referee referee;

    private void initBaseball() {
        gameResult = new GameResult();
        computer = new Computer();
        referee = new Referee();
    }

    public void playGame() {
        playerView.output(START_MESSAGE);
        do {
            playSingleGame();
            playerView.output(END_MESSAGE);
            playerView.output(INPUT_RETRY_EXIT_MESSAGE);
        } while (isRetry());
    }

    private void playSingleGame() {
        initBaseball();
        do {
            playerView.output(INPUT_NUMBERS_MESSAGE);
            String playerNumbers = playerView.input();
            Player player = new Player(playerNumbers);
            gameResult = referee.judge(computer, player);
            playerView.output(gameResult.result());
        } while (!gameResult.isWin());
    }

    private boolean isRetry() {
        String playerChoice = playerView.input();
        validateRetryExit(playerChoice);
        return playerChoice.equals(RETRY);
    }

    private void validateRetryExit(String playerChoice) {
        if ((!playerChoice.equals(RETRY) && !playerChoice.equals(EXIT)) ||
                playerChoice.isBlank()) {
            throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
        }
    }
}
