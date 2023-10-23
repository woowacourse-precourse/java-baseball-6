package baseball;

import static baseball.PlayerView.*;

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
            playerView.output(INPUT_RETRY_MESSAGE);
        } while (isRetry());
    }

    private void playSingleGame() {
        Computer computer = new Computer();
        String computerNumbers = computer.getComputerNumbers();
        do {
            playerView.output(INPUT_NUMBERS_MESSAGE);
            String playerNumbers = playerView.input();
            Player player = new Player(playerNumbers);
            gameResult = referee.judge(computerNumbers, playerNumbers);
            playerView.output(gameResult.result());
        } while (!gameResult.isWin());
    }

    private boolean isRetry() {
        String playerChoice = playerView.input();
        validateRetryExit(playerChoice);
        return playerChoice.equals(RETRY_NUMBER);
    }

    private void validateRetryExit(String playerChoice) {
        if (!Objects.equals(playerChoice, RETRY_NUMBER) ||
                !Objects.equals(playerChoice, EXIT_NUMBER)) {
            throw new IllegalArgumentException("1, 2만 입력할 수 있습니다.");
        }
    }
}
