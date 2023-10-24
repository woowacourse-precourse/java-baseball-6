package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.JudgeResult;
import baseball.view.OutputMessage;
import baseball.view.PlayerInput;

public class GameManager {
    private Computer computer;
    private Player player;
    private boolean isGameClear;

    public GameManager() {
        isGameClear = false;
        OutputMessage.printGameStartMsg();
    }

    void playGame() {
        boolean goGame = true;
        while (goGame) {
            oneRoundOfGame();
            OutputMessage.printGameExitOrRestartMsg();
            goGame = PlayerInput.isGameRestartInput();
        }
        OutputMessage.printGameFinishMsg();
    }

    private void settingGame() {
        isGameClear = false;
        computer = new Computer();
    }

    private void oneInputCycleOfGame() {
        OutputMessage.printInputNumMsg();
        player = new Player(PlayerInput.getInput());

        JudgeResult judge = new JudgeResult(computer, player);
        OutputMessage.printGameResult(judge.getResult());
        isGameClear = judge.isGameClear();
    }

    private void oneRoundOfGame() {
        settingGame();
        while (!isGameClear) {
            oneInputCycleOfGame();
        }
        OutputMessage.printGameClearMsg();
    }
}
