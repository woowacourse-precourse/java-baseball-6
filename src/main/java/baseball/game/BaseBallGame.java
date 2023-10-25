package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;

public class BaseBallGame {
    private static final String STRIKE_RESULT = "3스트라이크";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final Player player;
    private final Computer computer;
    private GameStatus gameStatus;

    public BaseBallGame(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        this.gameStatus = GameStatus.CONTINUE;
    }

    public void playGame() {
        while (isGameStarted()) {
            String result = computer.judgeGameResult(player.getNumbers());
            System.out.println(result);

            if (isWinningResult(result)) {
                System.out.println(WIN_MESSAGE);
                if (isRestartOrQuit()) break;
                computer.restartGame();
            }
        }
    }

    private boolean isGameStarted() {
        return gameStatus == GameStatus.CONTINUE;
    }

    private boolean isWinningResult(String result) {
        return STRIKE_RESULT.equals(result);
    }

    private boolean isRestartOrQuit() {
        if (player.checkRestartOrQuit()) {
            gameStatus = GameStatus.END;
            return true;
        }
        return false;
    }
}
