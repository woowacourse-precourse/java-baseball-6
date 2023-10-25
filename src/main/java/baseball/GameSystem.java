package baseball;

import java.util.List;

public class GameSystem {
    public void playGame() {
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame() {
        InputMsgView inputMsgView = new InputMsgView();
        inputMsgView.printStartMsg();

        Computer computer = new Computer();
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        inputMsgView.printInputNumberMsg();

        User user = new User();
        user.generateNumbers();
        List<Integer> userNumbers = user.getNumbers();

        BallStrikeCounter ballStrikeCounter = new BallStrikeCounter(computerNumbers, userNumbers);
        ballStrikeCounter.countBallAndStrikes();

        ResultMsgView resultMsgView = new ResultMsgView();
        resultMsgView.printGameResultMsg(ballStrikeCounter.getBallCount(), ballStrikeCounter.getStrikeCount());
    }

    private boolean restartGame() {
        InputMsgView inputMsgView = new InputMsgView();
        inputMsgView.printRestartMsg();

        return false;
    }
}
