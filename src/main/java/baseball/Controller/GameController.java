package baseball.Controller;

import baseball.Domain.AnswerJudge;
import baseball.Domain.ComputerNumberGenerator;
import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class GameController {
    private static List<Integer> ComputerNumber = ComputerNumberGenerator.generate();

    public GameController() {
        InputView.start();
    }

    public void run() {
        while (true) {
            play();
            if (!isContinue()) {
                break;
            }
        }
    }

    private void play() {
        String result = AnswerJudge.judge(InputView.UserInputView(), ComputerNumber);
        if (OutputView.isWin(result)) {
            return;
        }
        play();
    }

    private boolean isContinue() {
        return OutputView.isCon(InputView.choice());
    }

    public static void RegenerateComputerNumber() {
        ComputerNumber = ComputerNumberGenerator.generate();
    }
}
