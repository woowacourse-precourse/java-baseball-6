package baseball.game;

import baseball.computer.Computer;
import baseball.judgement.JudgeResult;
import baseball.player.Player;

import java.util.List;

public class BaseBallGame {
    private static final String STRIKE_RESULT = "3스트라이크";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final Player player;
    private final Computer computer;
    private final JudgeResult judgeResult;
    private GameStatus gameStatus;
    private List<Integer> computerNumbers;

    public BaseBallGame(Player player, Computer computer, JudgeResult judgeResult) {
        this.player = player;
        this.computer = computer;
        this.judgeResult = judgeResult;
        this.gameStatus = GameStatus.CONTINUE;
        this.computerNumbers = computer.generateNumbers();
    }

    public void playGame() {
        while (isGameStarted()) {
            String result = judgeGameResult();
            System.out.println(result);

            if (isWinningResult(result)) {
                System.out.println(WIN_MESSAGE);
                if (isRestartOrQuit()) break;

                restartGame();
            }
        }
    }

    private boolean isGameStarted() {
        return gameStatus == GameStatus.CONTINUE;
    }

    private String judgeGameResult() {
        return judgeResult.getResult(player.getNumbers(), computerNumbers);
    }

    private boolean isWinningResult(String result) {
        return STRIKE_RESULT.equals(result);
    }

    private void restartGame() {
        computerNumbers = computer.generateNumbers();
    }

    private boolean isRestartOrQuit() {
        if (player.checkRestartOrQuit()) {
            gameStatus = GameStatus.END;
            return true;
        }
        return false;
    }
}
