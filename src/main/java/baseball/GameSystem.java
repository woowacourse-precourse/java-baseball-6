package baseball;

import java.util.List;

public class GameSystem {

    private static final int THREE_STRIKES = 3;
    private final InputMsgView inputMsgView = new InputMsgView();
    private final User user = new User();

    public void playGame() {
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame() {
        inputMsgView.printStartMsg();

        Computer computer = new Computer();
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        inputMsgView.printInputNumberMsg();

        user.generateNumbers();
        List<Integer> userNumbers = user.getNumbers();

        BallStrikeCounter ballStrikeCounter = new BallStrikeCounter(computerNumbers, userNumbers);
        ballStrikeCounter.countBallAndStrikes();

        ResultMsgView resultMsgView = new ResultMsgView();
        resultMsgView.printGameResultMsg(ballStrikeCounter.getBallCount(), ballStrikeCounter.getStrikeCount());

        if (ballStrikeCounter.getStrikeCount() == THREE_STRIKES) {
            return;
        }
    }

    private boolean restartGame() {
        inputMsgView.printRestartMsg();

        user.decideGameRestart();

        return user.isGameRestart();
    }
}
