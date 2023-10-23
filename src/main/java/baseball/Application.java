package baseball;

import baseball.controller.NumberBaseBallGame;
import baseball.strategy.ForbidDuplicationPolicy;
import baseball.strategy.RandomNumberGeneratePolicy;
import baseball.strategy.ThreeNumberDigitPolicy;
import baseball.view.MissionUtilsInputView;
import baseball.view.PrintStreamOutputView;

public class Application {

    public static void main(String[] args) {
        new NumberBaseBallGame(
                new MissionUtilsInputView(),
                new PrintStreamOutputView(),
                new RandomNumberGeneratePolicy(),
                new ForbidDuplicationPolicy(),
                new ThreeNumberDigitPolicy()
        ).run();
    }

}
