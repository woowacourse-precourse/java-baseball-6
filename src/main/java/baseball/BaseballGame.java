package baseball;

import static baseball.PlayerView.*;

public class BaseballGame {
    private PlayerView playerView = new PlayerView();
    private Computer computer = new Computer();
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
        String computerNumbers = computer.generate();
        do {
            playerView.output(INPUT_NUMBERS_MESSAGE);
            String playerNumbers = playerView.input();
            gameResult = referee.judge(computerNumbers, playerNumbers);
            playerView.output(gameResult.result());
        } while (!gameResult.isWin());
    }

    private boolean isRetry() {
        return playerView.input().equals(RETRY_NUMBER);
    }
}
