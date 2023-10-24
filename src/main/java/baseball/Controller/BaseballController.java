package baseball.Controller;

import static baseball.Model.Count.ball;
import static baseball.Model.Count.strike;
import static baseball.View.InputView.printRestartPick;
import static baseball.View.OutputView.printStartGame;

import baseball.Model.Computer;
import baseball.Model.Count;
import baseball.Model.User;
import baseball.View.InputView;

public class BaseballController {
    private static final String RESTART_GAME = "1";
    private static final String CLOSE_GAME = "2";
    Count counter = new Count();
    Computer computer = new Computer();
    User user = new User();

    public void setGame() {
        counter.resetBall();
        counter.resetStrike();
        computer.generateRandom();
    }

    public void starGame() {
        setGame();
        printStartGame();
        tryStrike();
        printRestartPick();
        replayGame();
    }

    private void tryStrike() {
        while (strike != 3) {
            InputView.printRequestUserNum();
            String userInputNum = user.getUserNum();
            user.handleException(userInputNum);
            counter.resetBall();
            counter.resetStrike();
            for (int numIndex = 0; numIndex < 3; numIndex++) {
                int userNumIndex = Character.getNumericValue(userInputNum.charAt(numIndex));
                counter.checkBallAndStrike(numIndex, userNumIndex);
            }
            if (counter.countingBall(strike, ball)) {
                break;
            }
        }
    }

    public void replayGame() {
        String replayChoose = user.getUserNum();
        handleReplayException(replayChoose);
        if (replayChoose.equals(RESTART_GAME)) {
            starGame();
        }
        if (replayChoose.equals(CLOSE_GAME)) {
            return;
        }
    }

    public void handleReplayException(String replayChoose) {
        if (!replayChoose.equals(RESTART_GAME) && !replayChoose.equals(CLOSE_GAME)) {
            throw new IllegalArgumentException();
        }
    }
}
