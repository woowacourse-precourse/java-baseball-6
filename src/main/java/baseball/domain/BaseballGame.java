package baseball.domain;

import static baseball.global.constant.BaseballGameConstant.*;

import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;

    private static Computer computer;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printGameStart();
        computer = Computer.generate();

        play();
    }

    public void play() {
        Player player = Player.from(inputView.readPlayerNumbers());

        GameJudge judge = GameJudge.from(player, computer);
        judge.analyzeNumbers();
        judgeResult(judge.getBall(), judge.getStrike());

        proceed(judge.getBall(), judge.getStrike());
    }

    private void judgeResult(int ball, int strike) {
        if (strike == ALL_STRIKE) {
            outputView.printGameFinish();
        } else {
            outputView.printGameResult(ball, strike);
        }
    }

    private void proceed(int ball, int strike) {
        if (strike == ALL_STRIKE) {
            String option = inputView.readRestart();
            if (option.equals(IS_RESTART)) {
                computer = Computer.generate();
                play();
            } else if (option.equals(IS_STOP)) {
                return;
            }
        } else {
            play();
        }
    }
}
