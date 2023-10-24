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
    private PlayerView playerView = new PlayerView();
    private GameResult gameResult = new GameResult();
    private Referee referee = new Referee();

    public void playGame() {
        playerView.output(START_MESSAGE);
        do {
            playSingleGame();
            playerView.output(END_MESSAGE);
            playerView.output(INPUT_RETRY_EXIT_MESSAGE);
        } while (isRetry());
    }

    private void playSingleGame() {
        Computer computer = new Computer();
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
        if (!Objects.equals(playerChoice, RETRY) &&
                !Objects.equals(playerChoice, EXIT)) {
            throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
        }
    }
}
