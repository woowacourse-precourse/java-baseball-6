package baseball;

import baseball.domain.BallCounter;
import baseball.domain.ComputerNumbers;
import baseball.domain.ComputerNumbersGenerator;
import baseball.domain.PlayerNumbers;
import baseball.utils.GameStatusCommand;
import baseball.utils.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 숫자 야구 게임을 실행하는 역할을 수행한다.
 */
public class GameLauncher {

    private static final int DIGIT_NUMBER = 3;

    private final NumberGenerator numberGenerator;

    public GameLauncher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    /**
     * 숫자 야구 게임을 실행한다.
     */
    public void launch() {
        OutputView.printBeginningMessage();
        while (true) {
            playBaseball();
            GameStatusCommand gameStatusCommand = GameStatusCommand.of(InputView.readNumberOfGameStatusCommand());
            if (gameStatusCommand.isQuit()) {
                return;
            }
        }
    }

    private void playBaseball() {
        ComputerNumbers computerNumbers = ComputerNumbersGenerator.generate(numberGenerator, DIGIT_NUMBER);
        repeatBallCount(computerNumbers);
        OutputView.printEndingMessageForAllStrike(DIGIT_NUMBER);
    }

    private void repeatBallCount(ComputerNumbers computerNumbers) {
        while (true) {
            BallCounter.reset();
            PlayerNumbers playerNumbers = new PlayerNumbers(InputView.readNumbers(), DIGIT_NUMBER);
            playerNumbers.checkForBallCount(computerNumbers, DIGIT_NUMBER);
            if (BallCounter.isAllStrike(DIGIT_NUMBER)) {
                return;
            }
            OutputView.printBallCountResult(BallCounter.getCountOfBall(), BallCounter.getCountOfStrike());
        }
    }
}
