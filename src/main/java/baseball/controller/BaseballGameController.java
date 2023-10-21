package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private static final int END = 2;

    public void run() {

        OutputView.startMessage();

        while (true) {
            Balls computer = numberGenerator.generate();
            while (true) {
                Balls user = InputView.userInputNumber();

                OutputView.printRoundResult(computer, user);

                if (user.isThreeStrike(computer)) {
                    break;
                }
            }

            int restartResponse = InputView.RestartOrEnd();
            if (restartResponse == END) {
                break;
            }
        }

    }
}
