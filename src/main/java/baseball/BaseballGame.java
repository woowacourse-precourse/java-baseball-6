package baseball;

import static baseball.PlayerView.*;

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
            gameResult = referee.judge(computerNumbers, playerNumbers);
            playerView.output(gameResult.result());
        } while (!gameResult.isWin());
    }

    private boolean isRetry() {
        return playerView.input().equals(RETRY_NUMBER);
    }
}
