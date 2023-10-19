package baseball.application;

import baseball.domain.Computer;
import baseball.domain.GameProcessDecider;
import baseball.domain.GameProcessStatus;
import baseball.domain.Referee;
import baseball.domain.RoundResult;
import baseball.domain.User;
import baseball.io.InputProcessor;
import baseball.io.OutputProcessor;

import java.util.List;

public class GameManager {
    private final Computer computer;
    private final User user;
    private GameProcessStatus gameProcessStatus;

    public GameManager() {
        computer = Computer.init();
        user = new User();
        gameProcessStatus = GameProcessStatus.GAME_RUNNING;
    }

    public void run() {
        // 게임 시작
        OutputProcessor.printGameStart();

        while (gameProcessStatus.isGameInProgress()) {
            // Baseball 입력
            readUserBaseballs();

            // RoundResult 확인
            final RoundResult result = checkRoundResult();

            // 게임 클리어 확인
            checkGameClear(result);
        }
    }

    private void readUserBaseballs() {
        final List<Integer> balls = InputProcessor.readUserBaseballs();
        user.applyBaseball(balls);
    }

    private RoundResult checkRoundResult() {
        final RoundResult result = Referee.judge(computer.getBaseball(), user.getBaseball());
        OutputProcessor.printGameResult(result);
        return result;
    }

    private void checkGameClear(final RoundResult result) {
        if (result.isClear()) {
            OutputProcessor.printGameClear();
            determineGameProcess();
        }
    }

    private void determineGameProcess() {
        final int restartCommand = InputProcessor.readUserRestartCommand();
        final GameProcessDecider gameProcessDecider = GameProcessDecider.getDecider(restartCommand);

        if (gameProcessDecider.isRestart()) {
            computer.reset();
            gameProcessStatus = GameProcessStatus.GAME_RESTART;
            return;
        }

        gameProcessStatus = GameProcessStatus.GAME_TERMINATE;
    }
}
