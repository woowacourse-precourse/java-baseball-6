package baseball;

import baseball.domain.BallCounter;
import baseball.domain.ComputerNumbers;
import baseball.domain.ComputerNumbersGenerator;
import baseball.utils.NumberGenerator;
import baseball.domain.PlayerNumbers;
import baseball.utils.GameStatusCommand;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameLauncher {

    private static final int DIGIT_NUMBER = 3;

    private final NumberGenerator numberGenerator;

    public GameLauncher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

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
            computerNumbers.checkPlayerNumbers(playerNumbers, DIGIT_NUMBER);
            if (BallCounter.isAllStrike(DIGIT_NUMBER)) {
                return;
            }
            OutputView.printBallCountResult(BallCounter.getCountOfBall(), BallCounter.getCountOfStrike());
        }
    }
}
