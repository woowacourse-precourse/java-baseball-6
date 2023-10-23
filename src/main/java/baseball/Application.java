package baseball;

import baseball.controller.NumberBaseBallGame;
import baseball.policy.ForbidDuplicationPolicy;
import baseball.policy.RandomNumberGeneratePolicy;
import baseball.policy.ThreeDigitPolicy;
import baseball.view.MissionUtilsInputView;
import baseball.view.PrintStreamOutputView;

public class Application {

    public static void main(String[] args) {
        new NumberBaseBallGame(
                new MissionUtilsInputView(),
                new PrintStreamOutputView(),
                new RandomNumberGeneratePolicy(),
                new ForbidDuplicationPolicy(),
                new ThreeDigitPolicy()
        ).run();
    }

}
