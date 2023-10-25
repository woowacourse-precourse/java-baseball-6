package baseball.controller;

import baseball.utils.BallStrikeCounter;
import baseball.model.Computer;
import baseball.view.InputMsgView;
import baseball.view.ResultMsgView;
import baseball.model.User;
import java.util.List;

public class GameSystem {

    private static final int THREE_STRIKES = 3;
    private final InputMsgView inputMsgView = new InputMsgView();
    private final User user = new User();
    private BallStrikeCounter ballStrikeCounter;

    public void playGame() {
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame() {
        inputMsgView.printGameStartMsg();

        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.generateNumbers();

        do {
        inputMsgView.printInputNumberMsg();

        List<Integer> userNumbers = user.generateNumbers();

        ballStrikeCounter = new BallStrikeCounter(computerNumbers, userNumbers);
        ballStrikeCounter.countBallAndStrikes();

        ResultMsgView resultMsgView = new ResultMsgView();
        resultMsgView.printGameResultMsg(ballStrikeCounter.getBallCount(), ballStrikeCounter.getStrikeCount());

        } while (ballStrikeCounter.getStrikeCount() != THREE_STRIKES);
    }

    private boolean restartGame() {
        inputMsgView.printGameRestartMsg();

        user.decideGameRestart();

        return user.isGameRestart();
    }
}
